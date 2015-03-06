package com.incito.apktool.test;

import java.io.IOException;
import java.util.List;

import org.apkinfo.api.GetApkInfo;
import org.apkinfo.api.domain.ApkInfo;

public class test {

	public static void main(String[] args) throws IOException {
		ApkInfo apkinfo = GetApkInfo.getApkInfoByFilePath("F:\\SVN\\V100R001C02B0612(49).apk");
		System.out.println(apkinfo);
		apkinfo.
	}
}
