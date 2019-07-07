package ua.nure.rudenko.task2.part2;

import ua.nure.rudenko.task2.Container;

public interface List<E> extends Container<E> {
	void addFirst(E element);

	void addLast(E element);

	void removeFirst();

	void removeLast();

	E getFirst();

	E getLast();

	E search(E element);

	boolean remove(E element);
}
