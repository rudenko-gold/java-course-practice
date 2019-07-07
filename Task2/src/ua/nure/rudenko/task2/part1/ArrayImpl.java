package ua.nure.rudenko.task2.part1;

import java.util.Iterator;
import java.util.NoSuchElementException;

import ua.nure.rudenko.task2.part1.Array;

public class ArrayImpl<E> implements Array<E> {
	private static final int INITIAL_MAX_SIZE = 1000;
	private int maxSize;
	private int currentSize;
	private E[] data;
	
	ArrayImpl() {
		maxSize = INITIAL_MAX_SIZE;
		currentSize = 0;
		data = (E[]) new Object[maxSize];
	}
	
	private void shiftLeft(int startPosition) {
		for (int ind = startPosition; ind < currentSize; ind++) {
			data[ind] = data[ind + 1];
		}
	}
	
	public class IteratorImpl<E> implements Iterator<E> {
		private boolean isValid;
		private int currentPos = -1;

		@Override
		public boolean hasNext() {
			return (currentPos < currentSize - 1);
		}

		@Override
		public E next() {
			if (hasNext()) {
				currentPos++;
				isValid = true;
				return (E) (data[currentPos]);

			}
			throw new NoSuchElementException();
		}
		
		@Override
		public void remove() {
			if (!isValid) {
				throw new IllegalStateException();

			}
			currentSize--;
			shiftLeft(currentPos);
			currentPos--;
			data[currentSize] = null;
			isValid = false;
		}
	}
	
	@Override
	public void set(int index, E element) {
		data[index] = element;
	}
	
	@Override
	public int size() {
		return currentSize;
	}
	
	@Override
	public E get(int index) {
		return data[index];
	}

	@Override
	public void clear() {
		data = (E[]) new Object[maxSize];
		currentSize = 0;
	}
	
	@Override
	public IteratorImpl<E> iterator() {
		return new IteratorImpl<>();
	}
	
	private E[] resize(int newMaxSize, E[] arr) {
		E[] newData = (E[]) new Object[newMaxSize * 2];
		System.arraycopy(arr, 0, newData, 0, arr.length);
		return newData;
	}

	@Override
	public void add(E element) {
		if (currentSize == maxSize) {
			data = resize(maxSize, data);
		}
		
		data[currentSize] = element;
		currentSize += 1;
	}

	@Override
	public int indexOf(E element) {
		for (int ind = 0; ind < currentSize; ++ind) {
			if (data[ind] == element) {
				return ind;
			}
		}
		return -1;
	}

	@Override
	public void remove(int removeIndex) {
		currentSize -= 1;
		shiftLeft(removeIndex);
		data[currentSize] = null;
	}

	@Override
	public String toString() {
		StringBuilder bld = new StringBuilder();
		bld.append("[");
		for (int ind = 0; ind < currentSize; ++ind) {
			bld.append(data[ind].toString());
			if (ind != currentSize - 1) {
				bld.append(", ");
			}
		}
		bld.append("]");
		return bld.toString();
	}
}
