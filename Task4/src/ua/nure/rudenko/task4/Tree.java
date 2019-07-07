package ua.nure.rudenko.task4;

public class Tree<E extends Comparable<E>> {
	private Node<E> root;
	
	public boolean add(E element) {
		if (root == null) {
			root = new Node<>(element);
			return true;
		} else {
			return insert(element, root);
		}
	}
	
	private boolean insert(E element, Node<E> currNode) {
		if (element.compareTo(currNode.data) < 0) {
			if (currNode.left == null) {
				currNode.left = new Node<>(element);
				return true;
			} else {
				return insert(element, currNode.left);
			}
		} else if (element.compareTo(currNode.data) > 0) {
			if (currNode.right == null) {
				currNode.right = new Node<>(element);
				return true;
			} else {
				return insert(element, currNode.right);
			}
		} else {
			return false;
		}
	}

	public void add(E[] elements) {
		for (E element : elements) {
			add(element);
		}
	}
 
	public Node<E> find(E element) {
		Node<E> curr = root;
		while (curr != null) {
			if (curr.data.compareTo(element) == 0) {
				break;
			} else if (element.compareTo(curr.data) < 0) {
				curr = curr.left;
			} else {
				curr = curr.right;
			}
		}
		return curr;
	}
	
	private Node<E> minimum(Node<E> x) {
		  if (x.left == null) {
		     return x;
		  }
		  return minimum(x.left);
	}
	
	public boolean remove(E element) {
		Node<E> v = find(element);
		if (v == null) {
			return false;
		} else {
			delete(root, element);
			return true;
		}
	}
	
	
	private Node<E> delete(Node<E> root, E z) {
		  if (root == null) {
		    return root;
		  }
		  
		  if (z.compareTo(root.data) < 0) {
		    root.left = delete(root.left, z);
		  } else if (z.compareTo(root.data) > 0) {
		    root.right = delete(root.right, z);
		  } else if (root.left != null && root.right != null) {
		    root.data = minimum(root.right).data;
		    root.right = delete(root.right, root.data);
		  } else {
		    if (root.left != null) {
		      root = root.left;
		    } else {
		      root = root.right;
		    }
		  }
		  return root;
	}
	
	public void print() {
		printNode(root, 0);
	}
	
	private void printNode(Node<E> node, int h) {
		if (node != null) {
			printNode(node.left, h + 1);
			for (int i = 0; i < h; i++) {
				System.out.print("  ");
			}
			System.out.print(node.data + "\n");
			printNode(node.right, h + 1);
		}
	}

	private static class Node<E> {
		private Node<E> left;
		private Node<E> right;
		private E data;
		
		public Node (E value) {
			data = value;
			left = null;
			right = null;
		}
	}
}
