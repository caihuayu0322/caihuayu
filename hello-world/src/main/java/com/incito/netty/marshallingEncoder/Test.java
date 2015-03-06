package com.incito.netty.marshallingEncoder;

import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
	Map< String, String> a = new HashMap<String, String>();
	a.put("a", "a");
	System.out.println(a.get(null));
	}
}
