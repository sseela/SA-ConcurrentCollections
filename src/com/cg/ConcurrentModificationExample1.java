package com.cg;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class ConcurrentModificationExample1 extends Thread{

	static HashSet<String> set = new HashSet<>();
	
	@Override
	public void run() {
		
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Child thread trying to modify set");
		set.add("fifth");
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		set.add("first");
		set.add("second");
		set.add("third");
		set.add("fourth");
		
		ConcurrentModificationExample1 myThread = new ConcurrentModificationExample1();
		myThread.start();
		
		Iterator<String> itr = set.iterator();
		while(itr.hasNext()) {
			String nextVal = (String)itr.next();
			System.out.println("Main thread executing and current object is "+nextVal);
			Thread.sleep(new Long(3000));
		}
		
	}
}
