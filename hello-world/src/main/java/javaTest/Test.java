package javaTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		// Map<String, List<String>> a = new HashMap<String, List<String>>();
		// List<String> b = new ArrayList<String>();
		// b.add("b");
		// a.put("a", b);
		// List<String> c = a.get("a");
		// Iterator<String> it = c.iterator();
		// while (it.hasNext()) {
		// if (it.next().equals("b")) {
		// // it.remove();
		// }
		// }
		// System.out.println(a.get("a"));
		Map<String, String> a = null;
		a = new HashMap<String, String>();
		a=null;
		if (a != null &&a.get("1") == "3") {
			System.out.println(1);
		}
	}
}