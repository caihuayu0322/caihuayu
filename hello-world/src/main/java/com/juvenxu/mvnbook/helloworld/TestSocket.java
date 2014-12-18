package com.juvenxu.mvnbook.helloworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TestSocket {
	public static void main(String[] args) {
		try {
			ServerSocket server = null;
			try {
				server = new ServerSocket(30000);
				System.out.println("已经打开");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Socket socket = null;
			try {
				socket = server.accept();
				System.out.println("同意接受");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String line = null;
			System.out.println(11);
			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			InputStream iss = socket.getInputStream();
			System.out.println(22);
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			System.out.println(33);
			BufferedReader sin =  new BufferedReader(new InputStreamReader(System.in));
			System.out.println(44);
//			System.out.println("client:"+new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine());
			System.out.println("Client:"+iss.read());
			System.out.println("Client:"+is.readLine());
			System.out.println(55);
			line=sin.readLine();
			while(!line.equals("bye")){
				System.out.println(1);
				os.print(line);
				os.flush();
				System.out.println("server:"+line);
				System.out.println("Client:"+is.readLine());
				line = sin.readLine();
			}
			System.out.println("监听结束");
			os.close();
			is.close();
			socket.close();
			server.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
