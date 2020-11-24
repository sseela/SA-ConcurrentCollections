package com.cg;

import java.util.ArrayList;
import java.util.ListIterator;

public class ConcurrentModificationExample4 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("first");
		list.add("second");
		list.add("third");
		list.add("fourth");
		
		//This will throw exception
		/*ListIterator<String> itr5 = list.listIterator();
		while(itr5.hasNext()) {
			String nextVal = (String)itr5.next();
			if(nextVal.equals("third")) {
				list.add("fifth");
			}
		}
		System.out.println(list);*/
		
		//This will not throw
		ListIterator<String> itr = list.listIterator();
		while(itr.hasNext()) {
			String nextVal = (String)itr.next();
			if(nextVal.equals("third")) {
				list.set(2, "fifth");
			}
		}
		System.out.println(list);
		
	}
}
