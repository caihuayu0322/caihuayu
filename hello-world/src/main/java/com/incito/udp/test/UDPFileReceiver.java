package com.incito.udp.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPFileReceiver {
	 private int port = 1220;  
	    private DatagramSocket socket;  
	      
	    public UDPFileReceiver() throws SocketException{  
	        socket = new DatagramSocket(port);  
	        socket.setSoTimeout(40000);  
	    }  
	    public void reciveData() throws FileNotFoundException{  
	        File newfile = new File("642k.jpg");  
	        try {
				newfile.createNewFile();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
	        System.out.println(newfile.exists());
	        byte[] buf = new byte[192];  
	        FileOutputStream fos = new FileOutputStream(newfile);  
	        while(true){  
	            DatagramPacket packet = new DatagramPacket(buf, 192);  
	            try{  
	                socket.receive(packet);  
	                fos.write(packet.getData(), 0, packet.getLength());  
	            }catch(Exception e){  
	                try {  
	                    System.out.println("传输结束");  
	                    socket.close();  
	                    e.printStackTrace();
	                    fos.flush();  
	                    fos.close();  
	                } catch (IOException e1) {  
	                    // TODO Auto-generated catch block  
	                    e1.printStackTrace();  
	                }  
	                break;  
	            }  
	        }  
	    }  
	    public static void main(String[] args) throws FileNotFoundException, SocketException {  
	        new UDPFileReceiver().reciveData();  
	    } 
}
