package com.incito.netty.udp.test;

import java.awt.image.BufferedImage;
import java.net.InetSocketAddress;

public class ImageEvent {

	public static final byte seperator = ':';
	private final InetSocketAddress sourse;
	private final String imgfile;
	private final BufferedImage img;
	private final long received;
	
	public ImageEvent(String imgfile,BufferedImage img){
		this(null,imgfile,img,-1);
	}
	
	public ImageEvent(InetSocketAddress sourse,String imgfile,BufferedImage img,long received){
		this.sourse 	=	sourse;
		this.imgfile	=	imgfile;
		this.img	=	img;
		this.received	=	received;
	}
	
	public InetSocketAddress getSourse(){
		return sourse;
	}
	
	public long getReceivedTimeStamp(){
		return received;
	}
	
	public String getImgfile(){
		return imgfile;
	}
	
	public BufferedImage getImg(){
		return img;
	}
}
