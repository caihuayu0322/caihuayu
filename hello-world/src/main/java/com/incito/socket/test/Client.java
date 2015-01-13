package com.incito.socket.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1",8888);
			System.out.println("try to connect");
			InputStream is = System.in;
//			System.out.println(is.read);
//			System.out.println(is.read());
			OutputStream os =socket.getOutputStream();
			os.write(1);
			os.flush();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
