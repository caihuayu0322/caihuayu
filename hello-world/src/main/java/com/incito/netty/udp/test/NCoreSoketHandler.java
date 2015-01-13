package cn.com.incito.socket.core;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import cn.com.incito.classroom.base.MyApplication;
import cn.com.incito.common.utils.AndroidUtil;
import cn.com.incito.socket.message.MessagePacking;

import com.alibaba.fastjson.JSONObject;


/**
 * 通讯的核心处理器
 * 主要处理的是读操作
 * 	空闲时发送心跳
 *  连接的建立
 *  连接的关闭
 *  在netty中出现异常的操作
 * @author hm
 *
 */
public class NCoreSoketHandler extends ChannelInboundHandlerAdapter {

	private String name = NCoreSoketHandler.class.getSimpleName();
	
	/**
	 * 通道连接成功
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		MyApplication.Logger.debug(AndroidUtil.getCurrentTime() + ":"+name+":通道连接成功!");
		MyApplication.getInstance().setChannelHandlerContext(ctx);
	}
	
	/**
	 * 读取数据
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)throws Exception {
		
		//进行消息处理
		String message = (String) msg;
		JSONObject jsonObject = JSONObject.parseObject(message);
		
		MessagePacking messagePacking = JSONObject.parseObject(jsonObject.getString("messagePacking"), MessagePacking.class);
		byte msgId = messagePacking.msgId;
		
		//如果是心跳消息则也向服务器发送心跳消息
		if(Message.MESSAGE_HEART_BEAT == msgId){
			MessagePacking packing = new MessagePacking(Message.MESSAGE_HEART_BEAT);
			JSONObject json = new JSONObject();
			json.put("messagePacking", packing);
			MyApplication.Logger.debug(AndroidUtil.getCurrentTime() + ":获取到服务器消息:消息类型:" + msgId);
			ctx.writeAndFlush((json.toJSONString()+"$_").getBytes());
			
		}else{//执行相对应的消息处理
			MessageHandler messageHandler = MessageHandlerResource.getHandlerResources().getMessageHandler(msgId);
			MyApplication.Logger.debug(AndroidUtil.getCurrentTime() + ":获取到服务器消息:消息类型:" + msgId+":处理器是:"+messageHandler.toString());
			if(messageHandler != null){
				messageHandler.handleMessage(messagePacking.getJsonObject());
			}
		}
	}
	
	/**
	 * 事件的改变 
	 * 	读或者写 或者空闲
	 */
	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt)throws Exception {
		if(evt instanceof IdleStateEvent){
			IdleStateEvent event = (IdleStateEvent) evt;
			if (event.state() == IdleState.READER_IDLE) {
                /*读超时*/
            	MyApplication.Logger.debug(AndroidUtil.getCurrentTime() + ":" + name +"我已经在设置的读超时时间内没有获取到服务器消息,我将进行重连!");
                ctx.disconnect();
            } else if (event.state() == IdleState.WRITER_IDLE) {
                /*写超时*/   
            } else if (event.state() == IdleState.ALL_IDLE) {
            	
            }
		}
	}
	
	/**
	 * netty框架本身在处理中发生了一些异常
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)throws Exception {
		MyApplication.Logger.debug(AndroidUtil.getCurrentTime() + ":"+name+":发生了异常将主动关闭通道！");
		ctx.close();
	}
}
