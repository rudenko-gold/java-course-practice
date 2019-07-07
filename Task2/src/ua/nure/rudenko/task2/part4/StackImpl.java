package ua.nure.rudenko.task2.part4;

import java.util.Iterator;

import ua.nure.rudenko.task2.part2.ListImpl;

public class StackImpl<E> implements Stack<E> {
	private ListImpl<E> list = new ListImpl<>();

	@Override
	public void clear() {
		list.clear();
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public Iterator<E> iterator() {
		return list.iterator();
	}

	@Override
	public void push(E element) {
		list.addFirst(element);
	}

	@Override
	public E pop() {
		E temp = list.getFirst();
		list.removeFirst();
		return temp;
	}

	@Override
	public E top() {
		return list.getFirst();
	}

	public String toString() {
		return list.toStringst();
	}
}
