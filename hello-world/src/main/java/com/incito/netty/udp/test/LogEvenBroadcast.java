package com.incito.netty.udp.test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;

import javax.imageio.ImageIO;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.local.LocalAddress;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.InternetProtocolFamily;
import io.netty.channel.socket.nio.NioDatagramChannel;

public class LogEvenBroadcast {

	private final EventLoopGroup group;
	private final Bootstrap bootstrap;
	private final File file;
	
	public LogEvenBroadcast(InetSocketAddress address,File file){
		group = new NioEventLoopGroup();
		bootstrap = new Bootstrap();
			bootstrap.group(group)
							.channel(NioDatagramChannel.class)
							.option(ChannelOption.SO_BROADCAST, true)//while only one monitor exits,ignore this ?
							.handler(new LogEventEncoder(address))
							.localAddress(new InetSocketAddress(1121));
			//do not use localaddress()
			this.file = file;
	}
	public void run() throws IOException{
		Channel ch = bootstrap.bind(1111).syncUninterruptibly().channel();
		NioDatagramChannel a = new NioDatagramChannel(InternetProtocolFamily.IPv4);
		long pointer = 0;
//		for(;;){
//			long len = file.length();
//			if(len<pointer){
//				pointer = len;
//			}else if(len>pointer){
//				RandomAccessFile raf = new RandomAccessFile(file, "r");
//				raf.seek(pointer);
//				String line;
//			
//				while((line=raf.readLine())!=null){
//					ch.writeAndFlush(new LogEvent(null, -1, file.getAbsolutePath(), line));
//					
//				}
//				pointer = raf.getFilePointer();
//				raf.close();
//			}
//			try{
//				Thread.sleep(1000);
//			}catch(InterruptedException e){
//				Thread.interrupted();
//				break;
//			}
//			
//		}
//		for(;;){
			for(File file:new File("img").listFiles()){
				BufferedImage img = ImageIO.read(file);
				ImageEvent imageEvent = new ImageEvent(null, file.getAbsolutePath(), img, -1);
				ch.writeAndFlush(imageEvent);
			}
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
				Thread.interrupted();
			}
		}
//	}
	public void stop(){
		group.shutdownGracefully();
	}
	
	public static void main(String[] args) throws Exception {
//		if(args.length!=2){
//			System.out.println(args.length);
//			throw new IllegalArgumentException();
//		}
		LogEvenBroadcast logeven = new LogEvenBroadcast
				(new InetSocketAddress("255.255.255.255", 9090), new File("test.txt"));//dst 9090
		try{
			logeven.run();
		}finally{
			logeven.stop();
		}
	}
}
