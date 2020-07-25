package interviews;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Amazon {
	/*
	 * Given an array arr[] of N integers, the task is to find the minimum deletions
	 * required such that frequency of arr[i] is exactly arr[i] in the array for all
	 * possible values of i.
	 * 
	 * Input: arr[] = [1, 2, 2, 3, 3] Output: 2 Frequency(1) = 1 Frequency(2) = 2
	 * Frequency(3) = 2, frequency can’t be increased So, delete every occurrence of
	 * 3.
	 * 
	 * Input: arr[] = [2, 3, 2, 3, 4, 4, 4, 4, 5] Output: 3
	 * 
	 */

	public static void main(String[] args) {

		int[] arr = { 1, 2, 2, 3, 3 };

		/*
		 * public static int minDeletions(int[] arr){ Arrays.sort(arr); Set<Integer> s =
		 * new HashSet<Integer>(); int counter = 0; int output = 0; for(int n : arr){
		 * counter = n // counter = 2 if(!s.add(n) && counter != 0){ counter--; } else
		 * if (counter != 0){ output ++; // counter = 0; }else{ counter = 0; } } return
		 * output; }
		 */

	}

	public static int minDeletions(int[] arr){
        Arrays.sort(arr);
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int count = 1;
        int output = 0;
        for(int i = 0; i < arr.length; i++){
            if(hm.containsKey(arr[i])){ //1,2,2,3
                hm.put(arr[i], ++hm.get(arr[i]));
            }else{
                hm.put(arr[i], 1); 
            }
        }
        for(Map.Entry m : hm.entrySet()){
            if(m.getKey() != m.getValue()){
                output += m.getValue();
            }
            else if (m.getValue() > m.getKey(){
                output = output + m.getValue() - m.getKey();
            }
        }
        return output;
    }

}

/*
 * Reverse a linked list Given pointer to the head node of a linked list, the
 * task is to reverse the linked list. We need to reverse the list by changing
 * links between nodes. Examples:
 * 
 * Input: Head of following linked list 1->2->3->4->NULL Output: Linked list
 * should be changed to, 4->3->2->1->NULL
 * 
 * Input: Head of following linked list 1->2->3->4->5->NULL Output: Linked list
 * should be changed to, 5->4->3->2->1->NULL
 * 
 * Input: NULL Output: NULL
 * 
 * Input: 1->NULL Output: 1->NULL
 * 
 * Iterative Method
 * 
 * Initialize three pointers prev as NULL, curr as head and next as NULL.
 * Iterate trough the linked list. In loop, do following. // Before changing
 * next of current, // store next node next = curr->next // Now change next of
 * current // This is where actual reversing happens curr->next = prev
 * 
 * // Move prev and curr one step forward prev = curr curr = next
 */
// Java program for reversing the linked list

class LinkedList {

	static Node head;

	static class Node {

		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	/* Function to reverse the linked list */
	Node reverse(Node node) {
		Node prev = null;
		Node current = node;
		Node next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		node = prev;
		return node;
	}

	// prints content of double linked list
	void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.head = new Node(85);
		list.head.next = new Node(15);
		list.head.next.next = new Node(4);
		list.head.next.next.next = new Node(20);

		System.out.println("Given Linked list");
		list.printList(head);
		head = list.reverse(head);
		System.out.println("");
		System.out.println("Reversed linked list ");
		list.printList(head);
	}
}
