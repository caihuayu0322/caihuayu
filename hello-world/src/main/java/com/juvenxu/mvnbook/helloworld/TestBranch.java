package com.juvenxu.mvnbook.helloworld;

import java.net.*;
import java.io.*;

public class TestBranch {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1",30000);
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));//构造的时候为什么不提示呢？
			System.out.println(11);
			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println(22);
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			System.out.println(33);
			String readline;
			System.out.println(44);
			readline=sin.readLine();//如果系统没有值，为什么不报空指针//和以前接触的不一样，如果没有值系统会等待，直到处理完才会去处理下条语句
			System.out.println(readline);
			System.out.println(55);
			while(!readline.equals("bye")){//线程不死是因为这个吗？应该是因为这个
				System.out.println(readline);
				System.out.println(66);
				os.print(readline);
				System.out.println(77);
				os.flush();
				System.out.println(88);
				System.out.println("server:"+is.readLine());
				readline=sin.readLine();
			}
			os.close();
			is.close();
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
