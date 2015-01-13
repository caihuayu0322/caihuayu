package com.incito.netty.udp.test;

public class test {
	private static void foo() {  
		  
	    try {  
	        System.out.println("try");  
	        foo();  
	    } catch (Throwable e) {  
	        System.out.println("catch");  
	        foo();  
	    } finally {  
	        System.out.println("finally");  
	        foo();  
	    }  
	}  
	  
	public static void main(String[] args) {  
	    foo();  
	}  
}
