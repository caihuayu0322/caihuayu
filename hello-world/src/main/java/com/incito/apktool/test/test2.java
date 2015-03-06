package com.incito.apktool.test;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class test2 {
	
	public static void main(String[] args) throws Exception {
		String url = "http://localhost:8080/";
		String charset = "UTF-8";
		String param1 = "ccd29bf52f27";
		
		String query = String.format("mac=%s", 
			     URLEncoder.encode(param1, charset));
		
		URLConnection connection = new URL(url+"android/app/login?"+query).openConnection();
		connection.setRequestProperty("Accept-Charset", charset);
		
		InputStream response = connection.getInputStream();
		
		byte[] src= new byte[1024];
		StringBuffer sb = new StringBuffer();
		while(response.read(src)!=-1){
			sb.append(new String(src,charset));
		}
		System.out.println(new String(src,charset));
		JSONObject json = JSON.parseObject(new String(sb));
		
		org.json.JSONObject jsono= new org.json.JSONObject(new String(sb));
		System.out.println(jsono.getInt("code"));
		System.out.println(jsono.get("data"));
		org.json.JSONObject js = jsono.getJSONObject("data");
		System.out.println(js.getString("description"));
		
		
		
	}
}
