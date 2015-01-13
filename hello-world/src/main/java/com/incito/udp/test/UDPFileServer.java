package com.incito.udp.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UDPFileServer {
    private int port = 1220;  
    private String filePath = "";  
    private DatagramSocket socket;  
    public UDPFileServer() throws SocketException {  
        socket = new DatagramSocket(1220);  
        socket.setBroadcast(true);
//        socket.bind(new InetSocketAddress("255.255.255.255", 1220));
//        socket.bind(new InetSocketAddress(1220));
        //System.out.println("服务器启动成功");  
    }  
    public void service() throws IOException{  
        InputStream is = this.getClass().getResourceAsStream("641k.jpg");  
        byte[] buffer = new byte[192];  
        int len = 0;  
        while((len = is.read(buffer)) != -1){  
            System.out.println(len);  
            DatagramPacket packet = new DatagramPacket(buffer, len,InetAddress.getLocalHost(),port);  
            socket.send(packet);  
        }  
        socket.close();  
    }  
    public static void main(String[] args) throws SocketException, IOException {  
        new UDPFileServer().service();  
    }
}
