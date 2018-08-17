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

	public BstMultiset() {
		// Implement me!
		// 1. Initialize root node
		//root = new Node(null);
	} // end of BstMultiset()

	class Node{
		// Questions remain:
		// Do we need key for the nodes?
		// Does these value need to be private?
		private Node left;
		private Node right;
		private T element;
		private int count;

		// Does this have to be public
		Node(T element) {
			this.element = element;
			this.left = null;
			this.right = null;
			this.count = 1;
		}

		void addCount() {
			this.count++;
		}

		void remove() {
			this.count--;
		}

		void removeAll() {
			this.count = 0;
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
		if (isEmpty()) {
			this.root = new Node(item);
		} else {
			// Add value to current position
			this.add(root, item);
		}
	} // end of add()


	@Override
	public int search(T item) {
		Node result = search(root, item);
		if (result != null)
			System.out.println(result.element+" is on the tree!");
		else System.out.println("Value "+ item +" is not found!");
			//Output result.element and result.addCount
				//return nothing
				// default return, please Override when you implement this method
				return 0;
	} // end of add()

	@Override
	public void removeOne(T item) {
		// Implement me!
		Node result = search(root, item);
		result.remove();
	} // end of removeOne()

	@Override
	public void removeAll(T item) {
		// Implement me!
		Node result = search(root, item);
		result.removeAll();
	} // end of removeAll()

	@Override
	public void print(PrintStream out) {
		print(root, out);
	} // end of print()

	public boolean isEmpty(){
		return root == null;
	}

	public void add(Node node, T item){
		if (item.compareTo(node.element) == 0)
			node.addCount();
		else if (item.compareTo(node.element) < 0) {
			this.add(node.left, item);
		}
		else if (item.compareTo(node.element) > 0) {
			this.add(node.right, item);
		}
	}// end add()

	public  Node search(Node node, T item){
		while(node != null){
			if (item.compareTo(node.element) == 0)
				return node;
			else if (item.compareTo(node.element) < 0) {
				node = node.left;
			}
			else if (item.compareTo(node.element) > 0) {
				node = node.right;
			}
			return node;
		}
		return null;
	}// end search()

	public void print(Node node, PrintStream out) {
		if (node != null) {
			print(node.left, out);
			out.print(node.element + printDelim + node.count);
			print(node.right, out);
		}
	}// end print()

} // end of class BstMultiset
