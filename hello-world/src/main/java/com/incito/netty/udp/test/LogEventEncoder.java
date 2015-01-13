package com.incito.netty.udp.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.util.List;

import javax.imageio.ImageIO;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.util.CharsetUtil;

public class LogEventEncoder extends MessageToMessageEncoder<ImageEvent>{

	private final InetSocketAddress remoteAddress;
	
	public LogEventEncoder(InetSocketAddress remoteAddress){
		this.remoteAddress = remoteAddress;
	}
	
	@Override
	protected void encode(ChannelHandlerContext ctx, ImageEvent msg, List<Object> out) {
		// TODO Auto-generated method stub
		ByteBuf buf  = ctx.alloc().buffer();
//		buf.writeBytes(msg.getImgfile().getBytes(CharsetUtil.UTF_8));
//		buf.writeByte(LogEvent.SEPARATOR);
		InputStream is = this.getClass().getResourceAsStream("");
		byte [] dst = new byte [8192];
		int len = 0;
		while((len=is.read(dst))!=-1){
		ByteArrayOutputStream byteMsg = new ByteArrayOutputStream();
		try {
			ImageIO.write(msg.getImg(), "jpg", byteMsg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		buf.writeBytes(byteMsg.toByteArray());
		out.add(new DatagramPacket(buf, remoteAddress));
		DatagramPacket a = new DatagramPacket(buf, remoteAddress);
		ByteBuf buff = a.content();
		 
		System.out.println(buff);
	}

}
