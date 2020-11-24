package com.cg.COWAL;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {
	
	public static void main(String[] args) {
		
		CopyOnWriteArrayList<String> cowal = new CopyOnWriteArrayList<>();
		cowal.add("first");
		cowal.add("second");
		cowal.add("third");
		cowal.add("fourth");
		cowal.add("fifth");
		cowal.add("null");
		
		//This will not throw error because seperate copy will be created for each write operation
		/*Iterator<String> itr = cowal.iterator();
		while(itr.hasNext()) {
			String next = (String)itr.next();
			if(next.equals("third")) {
				cowal.add("pavan");					// a seperate copy of cowal will be created and element is added to that copy. So this new addition to copy will not be available to the iterator.
			}
		}
		System.out.println(cowal);*/
		
		//This will also not throw any error
		/*Iterator<String> itr = cowal.iterator();
		while(itr.hasNext()) {
			String next = (String)itr.next();
			if(next.equals("third")) {
				cowal.remove("first");					//copy of cowal will be created and removes element from that and later it is done sync
			}
		}
		System.out.println(cowal);*/
		
		//This will throw UnsupportedOperationException because everytime new copy will be created and upon which write operations are performed.
		//but when we directly perform any operations that changes modCount with iterator itself, then we will get exception Unsupported..
		Iterator<String> itr = cowal.iterator();
		while(itr.hasNext()) {
			String next = (String)itr.next();
			if(next.equals("third")) {
				itr.remove();
			}
		}
		System.out.println(cowal);
		
		
		
	}
}
