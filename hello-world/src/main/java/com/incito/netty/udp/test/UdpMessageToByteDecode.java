package com.incito.netty.udp.test;

import java.util.List;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageDecoder;

public class UdpMessageToByteDecode extends MessageToMessageDecoder<DatagramPacket>{


	@Override
	protected void decode(ChannelHandlerContext ctx, DatagramPacket msg, List<Object> out) throws Exception {
		out.add(msg.content());
		msg.retain();
	}

}
