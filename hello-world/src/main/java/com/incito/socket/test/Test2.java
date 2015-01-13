package com.incito.socket.test;

import java.net.DatagramSocket;
import java.net.SocketException;

public class Test2 {
	public Test2(){
		try {
			DatagramSocket server = new DatagramSocket(10000);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
}
