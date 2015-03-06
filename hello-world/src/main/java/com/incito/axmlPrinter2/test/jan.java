package com.incito.axmlPrinter2.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import test.AXMLPrinter;



public class jan {

	public static void main(String[] args)  {
	
		AXMLPrinter test = new AXMLPrinter();
		String a = test.getManifestXMLFromAPK("F:\\SVN\\V100R001C02B0612(49).apk");
		System.out.println(a);
		Map<String, String> b= readStringXmlOut(a);
		Iterator<Entry<String, String>> c =b.entrySet().iterator();
		while(c.hasNext()){
			Entry<String, String> d =c.next();
			System.out.println(d.getKey());
			System.out.println(d.getValue());
		}
	}
	
	public static Map<String, String> readStringXmlOut(String xml){
		Map<String, String> map = new HashMap<String, String>();   
        Document doc = null;   
        try {   
            // 将字符串转为XML   
            doc = DocumentHelper.parseText(xml);    
            // 获取根节点   
            Element rootElt = doc.getRootElement();    
            // 拿到根节点的名称   
            System.out.println("根节点：" + rootElt.getName());    
   
            // 获取根节点下的子节点head   
            Iterator<?> iter = rootElt.elementIterator("head");    
            // 遍历head节点   
            while (iter.hasNext()) {   
   
                Element recordEle = (Element) iter.next();   
                // 拿到head节点下的子节点title值   
                String title = recordEle.elementTextTrim("title");    
                System.out.println("title:" + title);   
                map.put("title", title);   
                // 获取子节点head下的子节点script   
                Iterator<?> iters = recordEle.elementIterator("script");    
                // 遍历Header节点下的Response节点   
                while (iters.hasNext()) {   
                    Element itemEle = (Element) iters.next();   
                    // 拿到head下的子节点script下的字节点username的值   
                    String username = itemEle.elementTextTrim("username");    
                    String password = itemEle.elementTextTrim("password");   
   
                    System.out.println("username:" + username);   
                    System.out.println("password:" + password);   
                    map.put("username", username);   
                    map.put("password", password);   
                }   
            }   
   
            //获取根节点下的子节点body   
            Iterator<?> iterss = rootElt.elementIterator("body");    
            // 遍历body节点   
            while (iterss.hasNext()) {   
                Element recordEless = (Element) iterss.next();   
                // 拿到body节点下的子节点result值   
                String result = recordEless.elementTextTrim("result");    
                System.out.println("result:" + result);   
                // 获取子节点body下的子节点form   
                Iterator<?> itersElIterator = recordEless.elementIterator("form");    
                // 遍历Header节点下的Response节点   
                while (itersElIterator.hasNext()) {   
                    Element itemEle = (Element) itersElIterator.next();   
                    // 拿到body下的子节点form下的字节点banlce的值   
                    String banlce = itemEle.elementTextTrim("banlce");    
                    String subID = itemEle.elementTextTrim("subID");   
   
                    System.out.println("banlce:" + banlce);   
                    System.out.println("subID:" + subID);   
                    map.put("result", result);   
                    map.put("banlce", banlce);   
                    map.put("subID", subID);   
                }   
            }   
        } catch (DocumentException e) {   
            e.printStackTrace();   
        } catch (Exception e) {   
            e.printStackTrace();   
        }   
        return map;   
		
		
	}
}
