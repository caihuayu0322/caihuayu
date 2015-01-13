package cn.com.incito.socket.core;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import com.alibaba.fastjson.JSONObject;

import cn.com.incito.classroom.base.MyApplication;
import cn.com.incito.common.utils.AndroidUtil;
import cn.com.incito.socket.message.MessagePacking;

/**
 * 使用netty框架实现具体的连接
 * @author hm
 */
public class NCoreSocket implements ICoreSocket {

	// 执行连接的线程池
	private ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
	private EventLoopGroup workerGroup = new NioEventLoopGroup();
	
	private static NCoreSocket scoketService;
	private NCoreSocket() {}

	public static NCoreSocket getInstance() {
		if (scoketService == null) {
			scoketService = new NCoreSocket();
		}
		return scoketService;
	}

	@Override
	public void startConnection(final String ip, final int port) {
		executor.execute(new Runnable() {
			@Override
			public void run() {
				try {
					Bootstrap bootstrap = new Bootstrap();
					bootstrap.group(workerGroup);
					bootstrap.channel(NioSocketChannel.class);
					bootstrap.option(ChannelOption.TCP_NODELAY, true);
					bootstrap.handler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch)throws Exception {
							ByteBuf delimiter = Unpooled.copiedBuffer("$_".getBytes());
							ChannelPipeline pipeline = ch.pipeline();

							// 空闲 消息编解码 与处理器
							pipeline.addLast(new IdleStateHandler(120, 0, 0));
							pipeline.addLast(new DelimiterBasedFrameDecoder(5*1024*1014, delimiter));
							pipeline.addLast(new StringEncoder());
							pipeline.addLast(new NCoreSoketHandler());
						}
					});

					// 进行连接
					ChannelFuture channelFuture = bootstrap.connect(ip, port).sync();
					MyApplication.Logger.debug(AndroidUtil.getCurrentTime() + ":NCoreSocket开始进行连接");
					//同步等待连接关闭 
					channelFuture.channel().closeFuture().sync();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					/**
					 * 清理相关的资源
					 */
					MyApplication.Logger.debug(AndroidUtil.getCurrentTime()+"NCoreSocket:通道断开,马上进行自动重连!");
					MyApplication.getInstance().setChannelHandlerContext(null);
					/**
					 * 进行重新连接
					 */
					try {
						Thread.sleep(2000);//休息两秒钟后进行重连
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					MyApplication.Logger.debug(AndroidUtil.getCurrentTime() + ":NCoreSocket开始进行重新连接");
					startConnection(ip, port);
				}
			}
		});
	}

	@Override
	public void stopConnection() {

	}

	@Override
	public void sendMessage(MessagePacking messagePacking) {
		ChannelHandlerContext ctx = MyApplication.getInstance().getChannelHandlerContext();
		if(ctx != null){
			JSONObject json = new JSONObject();
			json.put("messagePacking", messagePacking);
			ctx.writeAndFlush((json.toJSONString()+"$_").getBytes());
		}else{
			MyApplication.Logger.debug(AndroidUtil.getCurrentTime() + "NCoreSocket通道已经关闭,请等待重新连接后发送消息");
		}
	}

}
