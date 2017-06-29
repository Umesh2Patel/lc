package leetcode.com.leetcode;

import java.util.LinkedList;

import leetcode.com.leetcode.edtunambar.ListNode;



public class Merge2sortedLists {
/*
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.


 */
	public static void main(String[] args) {
//		LinkedList<ListNode> list = null;
//		ListNode l1 = null;
//		list.push(l1);
//		LinkedList<ListNode> list2 = null;
//		ListNode l2 = null;
//		list2.push(l2);
		
		
//		ListNode mergedList = mergeTwoLists(l1, l2);
	}
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
}
}
