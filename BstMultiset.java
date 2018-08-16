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
	} // end of BstMultiset()

	private class Node<T> {
// Questions remain:
// Do we need key for the nodes?
//Does these value need to be private?
					private Node left;
					private Node right;
					private <T> element;
//Does this have to be public
					Node(<T> element){
						this.element = element
						this.left = null;
						this.right = null;
					}


	}

	public void add(T item) {
		// Implement me!
		/* Check if the tree is empty or not:
				- If it is, the firts added item will be root


		*/

	} // end of add()


	public int search(T item) {
		// Implement me!

		// default return, please override when you implement this method
		return 0;
	} // end of add()


	public void removeOne(T item) {
		// Implement me!
	} // end of removeOne()


	public void removeAll(T item) {
		// Implement me!
	} // end of removeAll()


	public void print(PrintStream out) {
		// Implement me!
	} // end of print()

	public void isEmpty(){

	}

} // end of class BstMultiset
