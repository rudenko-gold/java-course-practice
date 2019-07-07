package ua.nure.rudenko.task2.part4;

import java.util.Iterator;

public class Part4 {

	public static void main(String[] args) {
		StackImpl<Integer> stack = new StackImpl<>();
		stack.push(1);
		System.out.print(stack.top());
		
		stack.push(2);
		System.out.print(stack.pop());
		System.out.print(stack.top());
		
		stack.push(3);
		stack.push(4);
		
		Iterator<Integer> it = stack.iterator();
		
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		
		System.out.print(stack.toString());
	}
}
