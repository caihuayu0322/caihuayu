package com.incito.socket.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SocketChannel;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(8888);
			System.out.println("open 8888 port");
			Socket socket = server.accept();
			System.out.println("connection come");
			InputStream is = socket.getInputStream();
			System.out.println(is.read()); 
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
