package com.incito.apktool.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


public class jan {

	public static void main(String[] args) {
//		ApkDecoder apk = new ApkDecoder();
//		File a = new File("F:\\SVN\\V100R001C02B0612(49).apk");
//		System.out.println("是否存在"+a.exists());
//		apk.setApkFile(a);
//		File b = new File("F:\\svn\\dir");
//		System.out.println(b.exists());
//		apk.setOutDir(b);
//		apk.decode();
//		System.out.println(apk.hasManifest());;
//		ApktoolProperties apks = new ApktoolProperties();
//		System.out.println(apks.get("VERSIONNAME"));
//		
//		AXmlResourceParser xml = new AXmlResourceParser();
//		xml.open(new FileInputStream(new File("f:\\svn\\AndroidManifest.xml")));
//		ResAttrDecoder a = new ResAttrDecoder();
//		xml.setAttrDecoder();
//		System.out.println(xml.getColumnNumber());
		
		JSONObject json = new JSONObject();
		json.put("1", "admin");
		String jsonString = json.toJSONString();
		json = JSON.parseObject(jsonString);
		System.out.println(json.toJSONString());
	}
}
