package com.juvenxu.mvnbook.helloworld;

public class Testkey {
	  static void exchange(StringBuffer a, int b){//��̬����������a,b��ֵ
		  a.delete(0, 2);
		  System.out.println(a);
		  b=b+1;
	    }
	    public static void main(String[] args){
	       StringBuffer i = new StringBuffer("abcdef");
	       int j = 100;
	       System.out.println("before call: " + "i=" + i + "\t" + "j = " + j);//����ǰ
	        exchange(i, j);                                                                    //ֵ���ݣ�main����ֻ�ܵ��þ�̬����
	        System.out.println("after call: " + "i=" + i + "\t" + "j = " + j);//���ú�
	    }
	}
