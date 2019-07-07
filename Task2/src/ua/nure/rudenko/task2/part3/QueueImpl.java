package ua.nure.rudenko.task2.part3;

import java.util.Iterator;

import ua.nure.rudenko.task2.part2.ListImpl;

public class QueueImpl<E> implements Queue<E> {
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
	public E top() {
		return list.getFirst();
	}
	
	@Override
	public void enqueue(E element) {
		list.addLast(element);
	}

	@Override
	public E dequeue() {
		E temp = list.getFirst();
		list.removeFirst();
		return temp;
	}
	
	@Override
	public Iterator<E> iterator() {
		return list.iterator();
	}

	public String toString() {
		return list.toString();
	}
}
