package com.incito.netty.udp.test;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class LogEventHandle extends SimpleChannelInboundHandler<ImageEvent>{

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, ImageEvent msg) {
		StringBuilder builder = new StringBuilder();
		builder.append(msg.getReceivedTimeStamp());
		builder.append("[");
		builder.append(msg.getSourse().toString());
		builder.append("]  [");
		builder.append(msg.getImgfile());
		builder.append("] : ");
		builder.append(msg.getImg());
		
		System.out.println(builder.toString());
		
		File direct = new File("paper");
		while(!direct.exists()){
			direct.mkdirs();
		}
		File file = new File("paper/1.jpg");
		try {
			ImageIO.write(msg.getImg(), "jpg", file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
		cause.printStackTrace();
		ctx.close();
	}

}
