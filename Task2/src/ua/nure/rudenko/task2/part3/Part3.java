package ua.nure.rudenko.task2.part3;

import java.util.Iterator;

public class Part3 {

	public static void main(String[] args) {
		QueueImpl<Integer> q = new QueueImpl<>();
		
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		
		System.out.print(q.top());
		System.out.print(q.dequeue());
		System.out.print(q.top());
		System.out.print(q.dequeue());
		System.out.print(q.dequeue());
		
		Iterator<Integer> it = q.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		
		System.out.print(q.toString());
	}

}
