package leetcode.com.leetcode.contest;

import java.util.Stack;

public class TwoSumIVInputisaBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*Java solution using 2 Stacks
	 * One Stack following the in order(s1) and another following reverse order(s2). Once we reach the left-most and the right-most node in a BST, we can start comparing them together.
	 * If the sum is less than the required value, pop out from s1, else pop from s2. Following is java implementation of the same:
	 * 
	 */
	public static boolean findTarget(TreeNode root, int k) {
		Stack<TreeNode> s1 = new Stack<TreeNode>();
	    Stack<TreeNode> s2 = new Stack<TreeNode>();
	    TreeNode current1 = root;
	    TreeNode current2 = root;

	    while (!s1.isEmpty() || !s2.isEmpty() ||
	            current1 != null || current2 != null) {
	        if (current1 != null || current2 != null) {
	            if (current1 != null) {
	                s1.push(current1);
	                current1 = current1.left;
	            }

	            if (current2 != null) {
	                s2.push(current2);
	                current2 = current2.right;
	            }
	        } else {
	            int v1 = s1.peek().val;
	            int v2 = s2.peek().val;
	            if (s1.peek() == s2.peek()) break;

	            if (v1 +  v2 == k) return true;

	            if (v1 + v2 < k) {
	                current1 = s1.pop();
	                current1 = current1.right;
	            } else {
	                current2 = s2.pop();
	                current2 = current2.left;
	            }
	        }
	    }

	    return false;
	}
	
	
}
