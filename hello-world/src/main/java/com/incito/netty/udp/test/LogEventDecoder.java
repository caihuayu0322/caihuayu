package com.incito.netty.udp.test;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.CharsetUtil;

public class LogEventDecoder extends MessageToMessageDecoder<DatagramPacket>{

	@Override
	protected void decode(ChannelHandlerContext ctx, DatagramPacket msg, List<Object> out) throws Exception {
		msg.retain();
		ByteBuf data = msg.content();
		int i = data.indexOf(0, data.readableBytes(), LogEvent.SEPARATOR);
//		System.out.println(i);
//		String imgfile = data.slice(0,i).toString(CharsetUtil.UTF_8);
		byte[]a = new byte[data.readableBytes()];
		data.getBytes(0, a);
		ByteArrayInputStream b = new ByteArrayInputStream(a);
		BufferedImage img=ImageIO.read(b);
		ImageEvent imgevent = new ImageEvent(msg.sender(), null, img, System.currentTimeMillis());
		out.add(imgevent);
	}

}
