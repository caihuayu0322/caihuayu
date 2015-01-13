package com.incito.netty.udp.test;

import java.util.List;

import org.apache.log4j.Logger;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageDecoder;

public class UdpRequestDecode extends MessageToMessageDecoder<DatagramPacket>{

	private static final Logger log = Logger.getLogger(UdpRequestDecode.class);
	
	
	@Override
	protected void decode(ChannelHandlerContext ctx, DatagramPacket msg, List<Object> out) throws Exception {
		// TODO Auto-generated method stub
		UdpRequestData requestData  = new udp
	}

}
