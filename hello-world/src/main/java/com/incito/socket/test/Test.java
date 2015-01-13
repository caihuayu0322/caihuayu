package com.incito.socket.test;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


public class Test {
public static void main(String[] args) {
//	byte[] a = new String("true").getBytes();
//	byte[] b = null;
//	try {
//		b = new String(a,"utf-8").getBytes();
//	} catch (UnsupportedEncodingException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	System.out.println(b.length);
//	Logger log = Logger.getLogger(Test.class.getName());
//	File a = new File("c:\\ads\\a");
//	try {
//		a.createNewFile();
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//		log.info(e.getMessage());
//	}
	for(int i = 0 ; i<10;i++){
		if(i==3){
			return;
		}
		System.out.println(i);
	}
	System.out.println(1);
}
}
