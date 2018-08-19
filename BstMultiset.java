import java.io.PrintStream;
import java.util.*;

/**
 * Binary search tree implementation of a multiset.
 *
 * @param T
 *            Type of elements that the multiset can hold.
 * @author Ken
 */
public class BstMultiset<T extends Comparable<T>> extends Multiset<T> {
	private Node root;

	BstMultiset() {
		// Implement me!
		// 1. Initialize root node
		//root = new Node(null);
	} // end of BstMultiset()

	class Node implements Comparable<T>{
		// Questions remain:
		// Do we need key for the nodes?
		// Does these value need to be private?
		private Node left;
		private Node right;
		private T element;
		private int count = 0;

		// Does this have to be public
		Node(T element) {
			this.element = element;
			this.left = null;
			this.right = null;
		}

		void addCount() {
			this.count++;
		}

		void remove() {
			this.count--;
		}

		T getT() {
			return element;
		}


		@Override
		public int compareTo(T o) {
			return getT().compareTo(o);
		}


	}

	@Override
	public void add(T item) {
		// Implement me!
		/*
		 * Check if the tree is empty or not: - If it is, the firts added item will be
		 * root - Else, return add(current node, value)
		 */
		// Check if the BST is empty:
			// Add value to current position
			if (isEmpty())root = add(root, item);
			else add(root, item);
	} // end of add()


	@Override
	public int search(T item) {
		Node result = search(root, item);
		if (result != null)
			return result.count;
		else
			//Output result.element and result.addCount
			//return nothing
			// default return, please Override when you implement this method
			return 0;
	} // end of add()

	@Override
	public void removeOne(T item) {
		// Implement me!
		Node result = search(root, item);
		if (result!= null){
			if (result.count != 0){
				result.remove();
			}
		}
	} // end of removeOne()

	@Override
	public void removeAll(T item) {
		// Implement me!
		Node result = search(root, item);
		if (result!= null){
			if (result.count != 0){
				result.count = 0;
			}
			//else result.remove();
		}
		//root = remove(root, item);
	} // end of removeAll()

	@Override
	public void print(PrintStream out) {
		print(root, out);
	} // end of print()

	public boolean isEmpty(){
		return root == null;
	}

	public Node add(Node node, T item){
		if (node == null)
			node = new Node(item);
		int compareResult = node.compareTo(item);
		//System.out.println(compareResult);
		if (compareResult > 0) {
			node.left = add(node.left, item);
		}
		else if (compareResult < 0) {
			node.right = add(node.right, item);
		}
		else if (compareResult == 0)
			node.addCount();
		return node;
	}// end add()


	public  Node search(Node node, T item){
		while(node != null){
			if (node.compareTo(item) == 0)
				return node;
			else if (node.compareTo(item) > 0) {
				node = node.left;
			}
			else if (node.compareTo(item) < 0) {
				node = node.right;
			}
		}
		return node;
	}// end search()


	public void print(Node node, PrintStream out) {
	/* ORDERED
	if (node != null) {
		print(node.left, out);
		out.println(node.element + printDelim + node.count);
		print(node.right, out);
	}
	 */
	if (node != null) {
		print(node.left, out);
		if(node.count != 0)
		out.println(node.element + printDelim + node.count);
		print(node.right, out);
	}
}// end print()

} // end of class BstMultiset
