package com.juvenxu.mvnbook.helloworld;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import sun.misc.OSEnvironment;

public class KeyGeneratorTest {


	public static void main(String[] args) throws Exception{
		//º”√‹
//		KeyGenerator key = KeyGenerator.getInstance("HmacMD5");
//		key.init(168);
//		SecretKey srtKey = key.generateKey();
//		FileOutputStream fos= new FileOutputStream("key.dat");
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
//		oos.writeObject(srtKey);
//		oos.close();
//		
//		FileInputStream fis = new FileInputStream("key.dat");
//		ObjectInputStream ois = new ObjectInputStream(fis);
//		SecretKey secKey=(SecretKey) ois.readObject();
//		byte[] bt=secKey.getEncoded();
//		String by= new String(bt);
//		StringBuffer a = new StringBuffer();
//		for (int i = 0; i < bt.length; i++) {
//			System.out.print(bt[i]);
//			a.append(bt[i]);
//		}
//		by= new String(a);
//		System.out.println();
//		System.out.println(a);
//		System.out.println(by);
//		ois.close();
		Map<String, String> user=System.getenv();
//		String userName= user.get("USERNAME");
//		System.out.println(userName);
//		File test = new File("c:"+File.separator+"users"+File.separator+userName+File.separator+"key"+File.separator+"key.dat");
//		if(!test.exists()){
//			test.createNewFile();
//		}
//		System.out.println(test.exists());
//		File test = new File("C:\\Users\\"+userName+"\\key\\key.dat");
//		System.out.println(test.exists());
//		if(!test.exists()){
//			File file = new File("C:\\Users\\JHON\\key");
//			file.mkdir();
//			test.createNewFile();
//		}
//		System.out.println(test.exists());
//		System.out.println(System.getProperty("USERNAME"));
//		System.out.println(System.getProperty("user.dir"));
//		Map<String, String> env = System.getenv();
//		List<String> list = (List<String>) env.values();
//		Iterator<String> itr = env.
	}
	
}
