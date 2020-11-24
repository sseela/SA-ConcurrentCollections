package com.cg;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {

	public static void main(String[] args) {
		
		ConcurrentHashMap<String, Integer> ch = new ConcurrentHashMap<String, Integer>();
		ch.put("first", 2000);
		ch.put("second", 7009);
		ch.putIfAbsent("second", 4000);
		ch.remove("second", 9000);
		ch.replace("second", 7009, 8000);
		System.out.println(ch);
		Iterator<String> itr = ch.keySet().iterator();
		while(itr.hasNext()) {
			if(itr.next().equals("first")) {
				ch.put("third", 7000);
			}
		}
		System.out.println(ch);
	}
	
}
