package com.juvenxu.mvnbook.helloworld;

import java.net.*;
import java.io.*;

public class TestBranch {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1",30000);
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));//�����ʱ��Ϊʲô����ʾ�أ�
			System.out.println(11);
			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println(22);
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			System.out.println(33);
			String readline;
			System.out.println(44);
			readline=sin.readLine();//���ϵͳû��ֵ��Ϊʲô������ָ��//����ǰ�Ӵ��Ĳ�һ�������û��ֵϵͳ��ȴ���ֱ��������Ż�ȥ�����������
			System.out.println(readline);
			System.out.println(55);
			while(!readline.equals("bye")){//�̲߳�������Ϊ�����Ӧ������Ϊ���
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
