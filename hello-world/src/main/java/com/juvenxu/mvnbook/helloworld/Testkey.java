package com.juvenxu.mvnbook.helloworld;

public class Testkey {
	  static void exchange(StringBuffer a, int b){//静态方法，交换a,b的值
		  a.delete(0, 2);
		  System.out.println(a);
		  b=b+1;
	    }
	    public static void main(String[] args){
	       StringBuffer i = new StringBuffer("abcdef");
	       int j = 100;
	       System.out.println("before call: " + "i=" + i + "\t" + "j = " + j);//调用前
	        exchange(i, j);                                                                    //值传递，main方法只能调用静态方法
	        System.out.println("after call: " + "i=" + i + "\t" + "j = " + j);//调用后
	    }
	}
