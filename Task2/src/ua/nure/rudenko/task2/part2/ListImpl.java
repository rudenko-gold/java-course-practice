package ua.nure.rudenko.task2.part2;

import java.util.Iterator;
import java.util.NoSuchElementException;

import ua.nure.rudenko.task2.part1.ArrayImpl.IteratorImpl;

public class ListImpl<E> implements List<E> {
	private Node<E> head;
	private int size;

	public ListImpl() {
		head = null;
	}

	static class Node<E> {
		private E value;
		private Node<E> next;

		Node() {
			value = null;
			next = null;
		}
		
		Node(E e) {
			value = e;
			next = null;
		}
		
		Node(E e, Node<E> nextNode) {
			value = e;
			next = nextNode;
		}
	}

	public class IteratorImpl<E> implements Iterator<E> {
		private Node<E> lastNode;
		private Node<E> additionalNode;
		private boolean isValid;
		
		@Override
		public boolean hasNext() {
			if (additionalNode == null && size > 0) {
				return true;
			} else {
				if (size == 0) {
					return false;
				}
				if (additionalNode != null) {
					return (additionalNode.next != null);
				} else {
					return false;
				}
			}

		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			if (additionalNode == null && size > 0) {
				additionalNode = (Node<E>) head;
			} else {
				lastNode = additionalNode;
				if (additionalNode != null) {
					additionalNode = additionalNode.next;
				}
			}
			isValid = true;
			if (additionalNode != null) {
				return additionalNode.value;
			} else {
				throw new NoSuchElementException();
			}
		}

		@Override
		public void remove() {
			if (!isValid) {
				throw new IllegalStateException();
			}
			
			if (lastNode == null) {
				additionalNode = null;
				removeFirst();
			} else {
				if (additionalNode.next != null) {
					lastNode.next = additionalNode.next;
				} else {
					removeLast();
				}
			}
			
			isValid = false;
		}
	}
	

	@Override
	public void clear() {
		head = null;
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterator<E> iterator() {
		return new IteratorImpl<>();
	}

	@Override
	public void addFirst(E element) {
		Node<E> temp = head;
		head = new Node<>(element, temp);
		size++;
	}

	@Override
	public void addLast(E element) {
		if (head == null) {
			head = new Node<>(element);
		} else {
			Node<E> currentNode = head;
			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
			currentNode.next = new Node<>(element);
		}
		size++;
	}

	@Override
	public void removeFirst() {
		head = head.next;
		size--;
	}

	@Override
	public void removeLast() {
		Node<E> currentNode = head;
		while (currentNode.next.next != null) {
			currentNode = currentNode.next;
		}
		currentNode.next = null;
		size--;
	}

	@Override
	public E getFirst() {
		return head.value;
	}

	@Override
	public E getLast() {
		Node<E> currentNode = head;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		return currentNode.value;
	}

	@Override
	public E search(E element) {
		Node<E> currentNode = head;
		while (currentNode != null) {
			if (currentNode.value.equals(element)) {
				return currentNode.value;
			}
			currentNode = currentNode.next;
		}
		return null;
	}

	@Override
	public boolean remove(E element) {
		Node<E> currentNode = head;
		Node<E> prevNode = null;
		while (currentNode != null) {
			if (currentNode.value.equals(element)) {
				if (currentNode == head) {
					removeFirst();
				} else {
					prevNode.next = currentNode.next;
				}
				return true;
			}
			prevNode = currentNode;
			currentNode = currentNode.next;
		}
		return false;
	}

	public String toString() {
		StringBuilder bld = new StringBuilder();
		bld.append("[");
		Node<E> currentNode = head;
		while (currentNode != null) {
			bld.append(currentNode.value.toString());
			if (currentNode.next != null) {
				bld.append(", ");
			}
			currentNode = currentNode.next;
		}
		bld.append("]");
		return bld.toString();
	}

	public String toStringst() {
		StringBuilder bld = new StringBuilder();
		bld.append("]");
		Node<E> currentNode = head;
		while (currentNode != null) {
			bld.append(currentNode.value.toString());
			if (currentNode.next != null) {
				bld.append(" ,");
			}
			currentNode = currentNode.next;
		}
		bld.append("[");
		String result = bld.toString();
		StringBuilder reverseResult = new StringBuilder();
		for (int i = result.length() - 1; i >= 0; i--) {
			reverseResult.append(result.charAt(i));
		}
		return reverseResult.toString();
	}
}
