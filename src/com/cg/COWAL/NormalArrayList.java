package com.cg.COWAL;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class NormalArrayList {

public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<>();
		list.add("first");
		list.add("second");
		list.add("third");
		list.add("fourth");
		list.add("fifth");
		
		//This will throw error because initially expectedModCount will be 5. And on addition of another object to list after that makes 
		//collection modCount to 6. So when itr.next() is called, we will get ConcurrentModificationException.
		
		/*Iterator<String> it = list.iterator();
		list.add("sixth");
		while(it.hasNext()) {
			String next = (String)it.next();
			if(next.equals("third")) {
				it.remove();
			}
		}
		System.out.println(list);*/
		
		
		
		//This will throw error
		/*for(String str: list) {
			list.add("six");
		}
		System.out.println(list);*/
		
		
		// we can modify the structure by using iterator or ListIterator methods.
		ListIterator<String> itr = list.listIterator();
		while(itr.hasNext()) {
			String str = itr.next();
			if(str.equals("second")) {
				itr.add("ffffff");
			} else {
				itr.remove();
			}
		}
		System.out.println(list);
		
}
}
