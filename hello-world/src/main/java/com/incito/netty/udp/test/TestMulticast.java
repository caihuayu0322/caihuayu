package com.incito.netty.udp.test;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ChannelFactory;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramChannel;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.internal.PlatformDependent;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

public class TestMulticast {
	private int port = 51972;

	private Logger log = Logger.getLogger(this.getClass());

	private InetAddress remoteInetAddr = null;
	private InetSocketAddress remoteInetSocket = null;
	private InetAddress localInetAddr = null;
	private InetSocketAddress localInetSocket = null;

	private DatagramChannel ch = null;
	private EventLoopGroup group = new NioEventLoopGroup();
	private boolean bSend = false;

	public TestMulticast(String localAddress, String remoteAddress, String sPort, boolean bSend) {
		this.bSend = bSend;
		try {
			localInetAddr = InetAddress.getByName(localAddress.trim());
			remoteInetAddr = InetAddress.getByName(remoteAddress.trim());
		} catch (Exception e) {
			log.error("Error creating InetAddresses. Local: " + localAddress + " Remote: " + remoteAddress, e);
		}
		try {
			port = Integer.parseInt(sPort);
		} catch (Exception e) {
			log.error("Error Parsing Port: " + sPort, e);
		}
	}

	public void run() throws Exception {
		log.debug("Run TestMulticast, Send Packet = " + bSend);
		try {
			localInetSocket = new InetSocketAddress(port);
			remoteInetSocket = new InetSocketAddress(remoteInetAddr, port);

			Bootstrap b = new Bootstrap();
			b.group(group);
			b.channelFactory(new ChannelFactory<Channel>() {
				@Override
				public Channel newChannel() {
					return new NioDatagramChannel(InternetProtocolFamily.IPv4);
				}
			});
			b.option(ChannelOption.SO_BROADCAST, true);
			b.option(ChannelOption.SO_REUSEADDR, true);
			b.option(ChannelOption.IP_MULTICAST_LOOP_DISABLED, false);
			b.option(ChannelOption.SO_RCVBUF, 2048);
			b.option(ChannelOption.IP_MULTICAST_TTL, 255);

			b.handler(new LoggingHandler(LogLevel.DEBUG));
			log.debug("Am I Logged on as ROOT: " + PlatformDependent.isRoot());
			ch = (DatagramChannel) b.bind(localInetSocket).sync().channel();
			log.debug("Result of BIND: " + ch.toString());
			if (remoteInetAddr.isMulticastAddress()) {
				NetworkInterface nic = NetworkInterface.getByInetAddress(localInetAddr);
				ChannelFuture future = ch.joinGroup(remoteInetSocket, nic);
				log.debug("Result of Join: " + future.toString());
			} else {
				log.debug("############NOT A MULTICAST ADDRESS: '" + remoteInetAddr.getHostAddress() + "'");
			}

			if (bSend) {
				group.scheduleAtFixedRate(new Runnable() {
					@Override
					public void run() {
						try {
							Date date = new Date();
							byte[] bytes = date.toString().getBytes();
							ByteBuf buffer = Unpooled.copiedBuffer(bytes);
							DatagramPacket packet = new DatagramPacket(buffer, remoteInetSocket, localInetSocket);
							ch.writeAndFlush(packet);
						} catch (Exception e) {
							log.error("Error Sending DatagramPacket", e);
						}
					}
				}, 0, 10, TimeUnit.SECONDS);
			}
		} catch (Exception e) {
			log.error(e);
		}
	}

	public void stop() {
		try {
			if (ch != null) {
				try {
					ch.close();
				} catch (Exception e) {
					log.error("Error Closing Channel", e);
				}
			}
			group.shutdownGracefully();
		} catch (Exception e) {
			log.error("Error ShuutingDown", e);
		}
	}
}
