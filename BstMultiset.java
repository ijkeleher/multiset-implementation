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

	} // end of BstMultiset()
	
	/**
	 * private node class for our tree, this will hold elements
	 */

	class Node implements Comparable<T>{
		private Node left;
		private Node right;
		private T element;
		private int count = 0;

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
    /**
     * Our add function
     * 
     * Check if the tree is empty or not: - If it is, the first added item will be
     * root - Else, return add(current node, value)
     */
	@Override
	public void add(T item) {
			if (isEmpty())root = add(root, item);
			else add(root, item);
	} // end of add()


	/**
	 *  traverse tree return number of items if found
	 */
	@Override
	public int search(T item) {
		Node result = search(root, item);
		if (result != null)
			return result.count;
		else

			return 0;
	} // end of search()
	
    /**
     * search tree for item and remove single instances if found
     */
	@Override
	public void removeOne(T item) {
		Node result = search(root, item);
		if (result!= null){
			if (result.count != 0){
			    //remove just decrements by 1
				result.remove();
			}
		}
	} // end of removeOne()

	/** search tree for item and set count to 0 if found*/
	@Override
	public void removeAll(T item) {
		Node result = search(root, item);
		if (result!= null){
			if (result.count != 0){
				result.count = 0;
			}
		}
	} // end of removeAll()

	
	@Override
	public void print(PrintStream out) {
		print(root, out);
	} // end of print()

	public boolean isEmpty(){
		return root == null;
	} // end of isEmpty()

	/** add item to a node, creating a new one if necessary
	 *  add to left or right depending on compareResults*/
	public Node add(Node node, T item){
		if (node == null)
			node = new Node(item);
		int compareResult = node.compareTo(item);
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

/**
 * our search function
 * initial node is the root node, traverses all nodes checking for item
 * 
 * */
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

    /** traverse the tree and print all nodes */
	public void print(Node node, PrintStream out) {
	if (node != null) {
		print(node.left, out);
		if(node.count != 0)
		out.println(node.element + printDelim + node.count);
		print(node.right, out);
	}
}// end print()

} // end of class BstMultiset
