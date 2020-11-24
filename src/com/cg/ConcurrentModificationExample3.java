package com.cg;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;

public class ConcurrentModificationExample3 {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<>();
		set.add("first");
		set.add("second");
		set.add("third");
		set.add("fourth");
		
		//This will throw exception
		Iterator itr4 = set.iterator();
		while(itr4.hasNext()) {
			String nextVal = (String)itr4.next();
			if(nextVal.equals("third")) {
				set.add("pavan");
			}
		}
		System.out.println(set);
		
		//This will also throw exception as modCount is changed
		Iterator itr = set.iterator();
		while(itr.hasNext()) {
			String nextVal = (String)itr.next();
			if(nextVal.equals("third")) {
				set.remove(nextVal);
			}
		}
		System.out.println(set);
		
		//This will not throw exception even if modCount is changed.
		Iterator itr2 = set.iterator();
		while(itr2.hasNext()) {
			String nextVal = (String)itr2.next();
			if(nextVal.equals("third")) {
				itr2.remove();
			}
		}
		System.out.println(set);
		
		
		
	}
}
