package ua.nure.rudenko.task2.part3;

import ua.nure.rudenko.task2.Container;

public interface Queue<E> extends Container<E> {
	void enqueue(E element);

	E dequeue();

	E top();
}