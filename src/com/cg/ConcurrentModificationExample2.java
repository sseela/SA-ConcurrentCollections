package com.cg;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class ConcurrentModificationExample2 {

	public static void main(String[] args) {
		
		
		HashMap map = new HashMap<>();
		map.put("sandeep", "first");
		map.put("narasimha", "second");
		map.put("kitta", "third");
		map.put("rohith", "fourth");
		
		
		//This will throw ConcurrentModificationException
		/*Iterator<String> itr1 = map.keySet().iterator();
		while(itr1.hasNext()) {
			String nextKey = (String)itr1.next();
			if(nextKey.equals("kitta")) {
				map.remove("rohith");	
			}
		}
		System.out.println(map);*/
		
		
		Iterator<String> itr1 = map.keySet().iterator();
		while(itr1.hasNext()) {
			String nextKey = (String)itr1.next();
			if(nextKey.equals("rohith")) {
				map.remove("narasimha");
			}
		}
		System.out.println(map);
				
		
		//This will not throw ConcurrentModificationException
		/*Iterator<Map.Entry<String, String>> itr = map.entrySet().iterator();
		while(itr.hasNext()) {
			Map.Entry<String, String> entry = (Map.Entry<String, String>)itr.next();
			if(entry.getKey().equals("rohith")) {
				entry.setValue("last");
			}
		}
		System.out.println(map);*/
		
		
		//This will not throw ConcurrentModificationException as we are using Iterator methods to modify structure
		/*Iterator<String> itr2 = map.keySet().iterator();
		while(itr2.hasNext()) {
			String nextKey = (String)itr2.next();
			if(nextKey.equals("kitta")) {
				itr2.remove();
			}
		}
		System.out.println(map);*/
		
		
		
		
	}
}
