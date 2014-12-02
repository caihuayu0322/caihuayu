package com.juvenxu.mvnbook.helloworld;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.SecretKeySpec;

import com.sun.crypto.provider.DESKeyFactory;

import sun.misc.OSEnvironment;
import sun.swing.SwingUtilities2.Section;

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
//		Map<String, String> user=System.getenv();
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
//		//test
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		byte[] keyData =new String("abcdefgf").getBytes();
		DESKeySpec des = new DESKeySpec(keyData);
		for (byte b : des.getKey()) {
			System.out.print(b);
		}
		System.out.println();
		Key key = keyFactory.generateSecret(des);
		for (byte b : key.getEncoded()) {
			System.out.print(b);
		}
		
		SecretKey a = new SecretKey() {
			
			@Override
			public String getFormat() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public byte[] getEncoded() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getAlgorithm() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		Cipher
		System.out.println();
		FileOutputStream fos = new FileOutputStream("./key/key.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(key);
		oos.close();
		
		FileInputStream fis = new FileInputStream("./key/key.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Key seckey= (Key) ois.readObject();
//		System.out.println(new String(seckey.getEncoded()));
		for (byte b : seckey.getEncoded()) {
			System.out.print(b);
		}
		ois.close();
//		File checkingKey = new File("./key/key.dat");
//		if(!checkingKey.exists()){
//			try {
//				File file = new File("./key");
//				file.mkdir();
//				checkingKey.createNewFile();
//				KeyGenerator key = KeyGenerator.getInstance("HmacMD5");
//				key.init(64);
//				SecretKey secKey = key.generateKey();
//				for (byte a : secKey.getEncoded()) {
//					System.out.print(a);
//				}
//				FileOutputStream fos = new FileOutputStream("./key/key.dat");
//				fos.write(secKey.getEncoded());
//				
//				fos.close();
//			} catch (NoSuchAlgorithmException e) {
//
//				e.printStackTrace();
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		try {
//			FileInputStream fis = new FileInputStream("./key/key.dat");
//			byte[] bt = new byte[8];
//			int length=fis.read(bt);
//			System.out.println(length);
//			String mac=new String(bt);
//			for (byte a : bt) {
//				System.out.print(a);
//			}
//			fis.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	
}
