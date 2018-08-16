import java.io.PrintStream;
import java.util.*;

/**
* @param T Type of elements that the multiset can hold.
* 
*/

public class LinkedListMultiset<T> extends Multiset<T>
{
  /** Reference to head node. */
	private LinkedListNode<T> head;
  /** Length of list. */
	private int size = 0;
  /** constructor */
	public LinkedListMultiset() {
		head = null;
		size = 0;
	} // end of LinkedListMultiset()


	public void add(T item) {

        Node newNode = new Node(item);

        // If head is empty, then list is empty and head reference need to be initialised.
        if (mHead == null) {
            mHead = newNode;
        }
        // otherwise, add node to the head of list.
        else {
            newNode.setNext(mHead);
            mHead = newNode;

        }

        mLength++;
		// Implement me!
		//doing the assignment
	} // end of add()


	public int search(T item) {

		Node currNode = mHead;
        for (int i = 0; i < mLength; ++i) {
        	if (currNode.getValue() == value) {
        		return true;
        	}
            currNode = currNode.getNext();
        }

        return false;
	} // end of add()


	public void removeOne(T item) {

		if (mLength == 0) {
			return false;
		}

		Node currNode = mHead;
		Node prevNode = null;

		// check if value is head node
		if (currNode.getValue() == value) {
			mHead = currNode.getNext();
			mLength--;
			return true;
		}

		prevNode = currNode;
		currNode = currNode.getNext();

		while (currNode != null) {
			if (currNode.getValue() == value) {
				prevNode.setNext(currNode.getNext());
				currNode = null;
				mLength--;
				return true;
			}
			prevNode = currNode;
			currNode = currNode.getNext();
		}


		return false;
	} // end of removeOne()


	public void removeAll(T item) {
		// Implement me!
	} // end of removeAll()


	public void print(PrintStream out) {
		// Implement me!
	} // end of print()

  private class LinkedListNode<T> {
    {
        /** number of times a value occurs*/
        private int count;
        /** Stored value of node. */
        private T value;
        /** Reference to next node. */
        private LinkedListNode<T> next;

        public Node(int value) {
            mValue = value;
            mNext = null;
        }

        public int getValue() {
            return mValue;
        }


        public Node getNext() {
            return mNext;
        }


        public void setValue(int value) {
            mValue = value;
        }


        public void setNext(Node next) {
            mNext = next;
        }
    } // end of inner class Node

} // end of class LinkedListMultiset
