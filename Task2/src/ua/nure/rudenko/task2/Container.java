package ua.nure.rudenko.task2;

import java.util.Iterator;

public interface Container<E> extends Iterable<E> {
	int size();
	
	void clear();
	
	String toString();
	
	Iterator<E> iterator();
}
