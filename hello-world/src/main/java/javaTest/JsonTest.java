package javaTest;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JsonTest {
public static void main(String[] args) {
	String result = "1";
	String data = "2";
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("code", result);
	map.put("data", data);
	String json = JSON.toJSONString(map);
	Map<String, Object> a = JSON.parseObject(json, HashMap.class);
	String b = (String) a.get("data");
	System.out.println(a.get("data"));;
}
}
