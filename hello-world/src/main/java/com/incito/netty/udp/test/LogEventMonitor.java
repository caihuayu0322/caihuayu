package com.incito.netty.udp.test;

import java.net.InetSocketAddress;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

public class LogEventMonitor {
	
	private final EventLoopGroup group;
	private final Bootstrap bootstrap ;
	
	public LogEventMonitor(InetSocketAddress address){
		group = new NioEventLoopGroup();
		
		bootstrap = new Bootstrap();
		bootstrap.group(group)
					.channel(NioDatagramChannel.class)
					.option(ChannelOption.SO_BROADCAST,true)
					.handler(new ChannelInitializer<Channel>() {

						@Override
						protected void initChannel(Channel ch) throws Exception {
							ChannelPipeline pipeline = ch.pipeline();
							pipeline.addLast(new LogEventDecoder());
							pipeline.addLast(new LogEventHandle());
						}
					}).localAddress(address);
	}
	
	public Channel bind(){
		return bootstrap.bind().syncUninterruptibly().channel();
	}
	
	public void stop(){
		group.shutdownGracefully();
	}
	
	public static void main(String[] args) {
		LogEventMonitor monitor = new LogEventMonitor(new InetSocketAddress(9090));
		
		try {
			Channel channel = monitor.bind();
			System.out.println("logEventMonitor is running");
			
			channel.closeFuture().await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			monitor.stop();
		}
		
	}
}
