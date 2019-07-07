package ua.nure.rudenko.task2.part1;

import java.util.Iterator;

import ua.nure.rudenko.task2.part1.ArrayImpl;

public class Part1 {

	public static void main(String[] args) {
		ArrayImpl<String> data = new ArrayImpl<>();
		
		data.add("First");
		data.add("Second");
		data.add("Third");
		
		Iterator<String> it = data.iterator();
		
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		
		System.out.print("\n" + data.toString());
	}
}
