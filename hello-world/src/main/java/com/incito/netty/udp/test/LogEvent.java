package com.incito.netty.udp.test;

import java.net.InetSocketAddress;

public final class LogEvent {

	public static final byte SEPARATOR = (byte)':';
	private final InetSocketAddress sourse;
	private final String logfile;
	private final String msg;
	private final long received;
	
	public LogEvent(String logfile,String msg){
		this(null,-1,logfile,msg);
	}

	public LogEvent(InetSocketAddress sourse, long received, String logfile, String msg) {
		this.sourse = sourse;
		this.received = received;
		this.msg = msg;
		this.logfile = logfile;
	}
	
	public InetSocketAddress getSourse(){
		return sourse;
	}
	
	public String getLogfile(){
		return logfile;
	}
	
	public long getReceivedTimestamp(){
		return received;
	}
	
	public String getMsg(){
		return msg;
	}
}
