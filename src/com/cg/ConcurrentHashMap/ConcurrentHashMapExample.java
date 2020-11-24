package com.cg.ConcurrentHashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {

	public static void main(String[] args) {
		
		ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<>();
		chm.put("sandeep", "first");
		chm.put("narasimha", "second");
		chm.put("kitta", "third");
		chm.put("rohith", "fourth");
		
		Iterator<String> itr = chm.keySet().iterator();
		while(itr.hasNext()) {
			String nextKey = (String)itr.next();
			if(nextKey.equals("kitta")) {
				chm.put("mukunda", "last");
			}
		}
		System.out.println(chm);

	}

}
