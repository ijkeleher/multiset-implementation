import java.io.PrintStream;
import java.util.*;

/**
 * @author Wenjian Zhu s3712782
 *
 */

public class SortedLinkedListMultiset<T extends Comparable<T>> extends Multiset<T> {

	Node<T, Integer> head;

	public SortedLinkedListMultiset() {
		head = null;
	} /** end of SortedLinkedListMultiset() */

	public void add(T item) {
		/** if added item is null, skip the rest.*/
		if (item == null)
			return;
		/** check if head exist, if it doesnt, add node head.*/
		if (head == null) {
			head = new Node<>(item, 1, null);
			return;
		/** set head if head exists*/
		} else if (head.element.compareTo(item) > 0) {
			Node<T, Integer> newHead = new Node<T,Integer>(item, 1, head);
			head = newHead;
			return;
		} else if (head.element.compareTo(item) == 0) {
			head.count++;
			return;
		}

		Node<T, Integer> currNode = head;
		Node<T, Integer> nextNode = currNode.next;
		/**iterate through nodes*/
		while (currNode.next != null && nextNode.element.compareTo(item) < 0) {
			currNode = nextNode;
			nextNode = nextNode.next;
		}
		/** either add item to current node or create new node*/
		if (nextNode != null){
			if (nextNode.element.compareTo(item) == 0){
				nextNode.count++;
			} else{
				currNode.next = new Node<T,Integer>(item, 1, nextNode);
			}
		} else {
			currNode.next = new Node<T,Integer>(item, 1, nextNode);
		}
	} /** end of add() */

	/**Can work as a binary search */
	public int search(T item) {
		if (head == null) {
			return 0;
		}
		/** set current node to head of the linkedlist */
		Node<T, Integer> currNode = head;
		/** for each element in list check if element matches item */
		while (currNode.element.compareTo(item) < 0 && currNode.next != null) {
			currNode = currNode.next;
		}
		/** if we find a match return the count */
		if (currNode.element.equals(item)) {
			return currNode.count;
		}
		// default return, please override when you implement this method
		return 0;
	} /** end of add() */

	/** remove a single item */
	public void removeOne(T item) {
		if (head == null) {
			return;
		}
		/** remove single item from head if necessary */
		if (head.element.compareTo(item) == 0) {
			head.count--;
			if (head.count == 0) {
				head = head.next;
			}
			return;
		}

		Node<T, Integer> prevNode = head;
		Node<T, Integer> currNode = head.next;
		
		/** remove single item from list */
		while (currNode.element.compareTo(item) < 0 && currNode.next != null) {
			prevNode = currNode;
			currNode = currNode.next;
		}

		if (currNode.element.equals(item)) {
			currNode.count--;
			if (currNode.count == 0) {
				prevNode.next = currNode.next;
			}
		}

	} // end of removeOne()

	public void removeAll(T item) {
		if (head == null) {
			return;
		}

		if (head.element.compareTo(item) == 0) {
			head = head.next;
			return;
		}

		Node<T, Integer> prevNode = head;
		Node<T, Integer> currNode = head.next;

		while (currNode.element.compareTo(item) < 0 && currNode.next != null) {
			prevNode = currNode;
			currNode = currNode.next;
		}

		if (currNode.element.equals(item)) {
			prevNode.next = currNode.next;
		}
	} // end of removeAll()

	@Override
	public void print(PrintStream out) {
		if(head == null) {
            return;
    }
    Node<T, Integer> currNode = head;

    //iterate through list
    while (currNode != null){
      //if count for current node is
      if (currNode.count != 0){
            System.out.println(currNode.element + printDelim + currNode.count);
          }
            currNode = currNode.next;
    }
	} // end of print()

	private class Node<T, Integer> {
		/** Stored element inside node (the element). */
		private T element;
		/** count of element*/
		private Integer count;
		/** Reference to next node. */
		private Node<T, Integer> next;
		/** node constructor */
		Node(T element, Integer count, Node<T, Integer> next) {
		        this.element = element;
		        this.count = count;
		        this.next = next;
		}
	}

} // end of class SortedLinkedListMultiset
