import java.io.PrintStream;
import java.util.*;

/**
 * @author Inci Keleher s3646416
 * @param T Type of elements that the multiset can hold.
 *
 */

public class LinkedListMultiset<T> extends Multiset<T> {

/** Reference to head node...
 * not a pointer because java doesn't have pointers?
 * or it does but they are immutable? ...anyway moving on
 */
Node<T, Integer> head;
int size;

/** constructor */
public LinkedListMultiset() {
        head = null;
        size = 0;
}           // end of constructor


public void add(T item) {
        /** If head is empty, create node with item and set count to 1
         * and pointer to next node as null and set as head
         */
        if (head == null) {
                Node<T, Integer> newNode = new Node<>(item, 1, null);
                head = newNode;
                return;
        }
        /** otherwise, set currentNode to head*/
        Node<T, Integer> currNode = head;
        /** iterate through list */
        while (!currNode.value.equals(item) && currNode.next != null) {
                currNode = currNode.next;
        }
        /**if value equal to existing value increment count */
        if(currNode.value.equals(item)) {
                currNode.count++;
                return;
        }
        /**otherwise add new node and update pointer of previous node */
        Node<T, Integer> newNode = new Node<>(item, 1, null);
        currNode.next = newNode;

}   // end of add()


public int search(T item) {

        if (head == null) {
                return 0;
        }
        /** set current node to head of the linkedlist */
        Node<T, Integer> currNode = head;
        /** for each element in list check if value matches item */
        while (!currNode.value.equals(item) && currNode.next != null) {
                currNode = currNode.next;
        }
        /** if we find a match return the count */
        if(currNode.value.equals(item)) {
                return currNode.count;
        }
        /** return false if no matches found */
        return 0;
}   // end of search()


public void removeOne(T item) {
        /** removing a SINGLE item from the list */

        /**check if there are nodes to remove */

        if (head == null) {
                return;
        }

        /**dealing with head node**/

        if (head.value.equals(item)) {
                head.count--;
                if (head.count == 0) {
                        head = head.next;
                }
                return;
        }

        if(head.next == null) {
                return;
        }

        /** set new PreNode and currNode
         * let's deal with other nodes*/

        Node<T, Integer> prevNode = head;
        Node<T, Integer> currNode = head.next;

        while (!currNode.value.equals(item) && currNode.next != null) {
                currNode = currNode.next;
        }

        if(currNode.value.equals(item)) {
                currNode.count--;
                if (currNode.count == 0) {
                        prevNode.next = currNode.next;
                }
        }

}   // end of removeOne()

public void removeAll(T item) {
    /** removing ALL of an instance of an item from the list */

    /** check if there are any nodes to remove*/
    if (head == null){
        return;
    }
    
    Node<T, Integer> currNode = head;
    
    while(head!=null&&head.value.equals(item)){
        currNode = head;
        head = head.next;
        currNode.next = null;
        currNode = null;   
    }
    
    currNode = head;
    
    while(currNode !=null && currNode.next != null){
        if(currNode.next.value.equals(item)){
            Node<T, Integer> prevNode = currNode.next;
            currNode.next = prevNode.next;
            prevNode.next = null;
            prevNode = null;
            
        }
        else{
            currNode = currNode.next;
        }
    }
        
}   // end of removeAll()

public void print(PrintStream out) {
        if(head == null) {
                return;
        }
        Node<T, Integer> currNode = head;

        do {
                System.out.println(currNode.value + printDelim + currNode.count);
                currNode = currNode.next;
        } while (currNode != null);



}   // end of print()

private class Node<T, Integer> {
/** Stored value inside node (the element). */
private T value;
/** count of element*/
private Integer count;
/** Reference to next node. */
private Node<T, Integer> next;
/** node constructor */
Node(T value, Integer count, Node<T, Integer> next) {
        this.value = value;
        this.count = count;
        this.next = next;
}

}  // end of inner class Node

} // end of class LinkedListMultiset
