package com.tyss.collectionframework.queue;

import java.util.PriorityQueue;

public class PriorityQueue1 {

	public static void main(String[] args) 
	{
		PriorityQueue p1= new PriorityQueue<>();
		
		p1.offer(12);
		p1.offer(2);
		p1.offer(95);
		p1.offer(23);
		p1.offer(-10);
		
		System.out.println(p1);
		
		p1.poll();
		System.out.println(p1);
		p1.poll();
		System.out.println(p1);
		
		p1.remove();
		System.out.println(p1);
		
		System.out.println(p1.peek());
		
		System.out.println(p1.element());
	}

}
