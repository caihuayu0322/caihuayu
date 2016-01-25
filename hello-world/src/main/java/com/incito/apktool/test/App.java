package com.incito.apktool.test;

import java.util.Date;


public class App {

	private int id;
	private String name;
	private int code;
	private String version;
	private String url;
	private String md5;
	private String iconPath;
	private String description;
	private Date ctime;
	private Date lastModified;
	private String packageName;
	23
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMd5() {
		return md5;
	}
	public void setMd5(String md5) {
		this.md5 = md5;
	}
	public String getIconpath() {
		return iconPath;
	}
	public void setIconpath(String iconpath) {
		this.iconPath = iconpath;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	public Date getLastmodified() {
		return lastModified;
	}
	public void setLastmodified(Date lastmodified) {
		this.lastModified = lastmodified;
	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	
}
