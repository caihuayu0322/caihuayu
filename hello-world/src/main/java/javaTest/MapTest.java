package javaTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MapTest {

	public static void main(String[] args) {
		/*
		 * 测试
		 */
//		Map<String, List<String>> a =  new HashMap<String, List<String>>();
//		Map<String,List<String>> b = new HashMap<String, List<String>>();
//		List<String> c = new ArrayList<String>();
//		c.add("213");
//		a.put("a1", c);
//		b.put("b1", c);
//		a.remove("a1");
//		System.out.println(b.get("b1").toString());
//		a.put("a1", c);
//		a.get("a1").add("214");
//		System.out.println(b.get("b1").toString());
		/*
		 * 测试放入空值的时候，map如何遍历
		 * 结果：1、无论放入多少空key和空值，值遍历出一个
		 * 2、放入实值空key，遍历出一个
		 */
		Map<String, String> a = new HashMap<String,String>();
		a.put("1", "1");
		a.put(null, null);
		a.put(null, null);
		a.put("3", null);
		a.put(null, "3");
		a.put(null, null);
		a.put("2", "2");
		Iterator<Entry<String, String>> b = a.entrySet().iterator();
		while(b.hasNext()){
			Entry<String,String> c = b.next();
			System.out.println(c.getKey()+";"+c.getValue());
		}
	}
}
