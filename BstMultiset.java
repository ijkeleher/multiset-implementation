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
			root = new Node(item);
			root.addCount();
		} else {
			// Add value to current position
			this.add(root, item);
		}
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
			if (result.count == 1){
				removeAll(item);
			}
			else result.remove();
		}
	} // end of removeOne()

	@Override
	public void removeAll(T item) {
		// Implement me!
		root = remove(root, item);
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
		if (item.compareTo(node.element) < 0) {
			node.left = add(node.left, item);
		}
		else if (item.compareTo(node.element) > 0) {
			node.right = add(node.right, item);
		}
		else if (item.compareTo(node.element) == 0)
			node.addCount();
		return node;
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
			out.println(node.element + printDelim + node.count);
			print(node.left, out);
			print(node.right, out);
		}
	}// end print()

	public Node remove(Node node, T item) {
		if (node == null) {
			return node;
		}
		int compareResult = item.compareTo(node.element);
		if (compareResult < 0) {
			node.left = remove(node.left, item);
		}
		else if (compareResult > 0) {
			node.right = remove(node.right, item);
		}
		// now node is where the element is.
		// check if node has no children
		else if (node.right != null && node.left != null) {
			node.count = rightMinNode(node).count;
			node.element = rightMinNode(node).element;
			node.right = remove(node.right, node.element);
		}
		else {
			if (node.left != null) {
				node = node.left;
			}
			else if (node.right != null) {
				node = node.right;
			}
		}
		return node;
	}//end remove()

/*
	public void delete(Node parent, Node child){
		if (child.left == null && child.right ==null) {
			if (child == root){
				root = null;
			}
			else if (parent.compareTo(child.element) < 0) {
				parent.left = null;
			}
			else if (parent.compareTo(child.element) > 0) {
				parent.right = null;
			}
		}
		else if (child.left == null || child.right == null) {
			if (child == root) {
				if (child.left != null) {
					root = child.left;
				}
				else if (child.right != null) {
					root = child.right;
				}
			}
			else if (parent.compareTo(child.element) < 0) {
				if (child.left != null) {
					parent.right = child.left;
				}
				else if (child.right != null) {
					parent.right = child.right;
				}
			}
			else if (parent.compareTo(child.element) > 0) {
				if (child.left != null) {
					parent.left = child.left;
				}
				else if (child.right != null) {
					parent.left = child.right;
				}
			}
		}
		else {

		}
	}
	*/

	public Node rightMinNode(Node node){
		Node result = node.right;
		while(result.left != null){
			result = result.left;
		}
		return result;
	} // end of rightMinNode()

} // end of class BstMultiset
