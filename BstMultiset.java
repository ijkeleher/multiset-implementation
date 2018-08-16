import java.io.PrintStream;
import java.util.*;

/**
* Binary search tree implementation of a multiset.
*
* @param T Type of elements that the multiset can hold.
* @author Ken
*/
public class BstMultiset<T> extends Multiset<T>
{
	public BstMultiset() {
		// Implement me!
		// 1. Initialize root node
		private Node root;
		private Node pointer = root;
	} // end of BstMultiset()

	private class Node<T> {
// Questions remain:
// Do we need key for the nodes?
//Does these value need to be private?
					private Node left;
					private Node right;
					private <T> element;
					private int count;
//Does this have to be public
					Node(<T> element){
									this.element = element
									this.left = null;
									this.right = null;
									this.instance = 1;
					}

					addCount()	this.intance++;
	}

	@override
	public void add(T item) {
		// Implement me!
		/* Check if the tree is empty or not:
				- If it is, the firts added item will be root



		*/
		//Check if the BST is empty:
		if (isEmpty()){
						this.root = new Node(item);
		}
		else{
			this.add(root, item)
		}
		elif (item.compareTo(node.element) < 0){
						this.add(node.left, item);
		}
		elif (item.compareTo(node.element) > 0){
						this.add(node.right, item);
		}
		elif item.compareTo(node.element) = 0{
						node.addCount();
		}


	} // end of add()

	@override
	public int search(T item) {
		// Implement me!

		// default return, please override when you implement this method
		return 0;
	} // end of add()

	@override
	public void removeOne(T item) {
		// Implement me!
	} // end of removeOne()

	@override
	public void removeAll(T item) {
		// Implement me!
	} // end of removeAll()

	@override
	public void print(PrintStream out) {
		// Implement me!
	} // end of print()

	public void isEmpty(){
		if(root == null)
		return true;
	}

	public Node add(Node node, <T> item){

	}

	public Node search(Node node, <T> item){

	}

} // end of class BstMultiset
