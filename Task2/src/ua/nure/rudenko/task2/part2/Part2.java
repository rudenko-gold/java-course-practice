package ua.nure.rudenko.task2.part2;
import java.util.Iterator;

import ua.nure.rudenko.task2.part2.ListImpl;
public class Part2 {

	public static void main(String[] args) {
		ListImpl<Integer> list = new ListImpl<>();
		
		list.addLast(1);
		System.out.print(list.toString() + "\n");
		list.addLast(2);
		System.out.print(list.toString() + "\n");
		list.addLast(3);
		System.out.print(list.toString() + "\n");
		list.remove(1);
		System.out.print(list.toString() + "\n");
		list.remove(2);
		System.out.print(list.toString() + "\n");
		
		Iterator<Integer> iter = list.iterator();
		
		while(iter.hasNext()) {
			System.out.print(iter.next());
		}
		
		System.out.print("\n");
		
		for(Integer element : list) {
			System.out.print(element);
		}
	}
}
