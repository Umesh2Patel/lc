package leetcode.com.leetcode;

public class MinDepOfBinTree {
	
	/*
	 * Given a binary tree, find its minimum depth.

	The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
	
	Note: A leaf is a node with no children.
	
	Example:
	
	Given binary tree [3,9,20,null,null,15,7],
	
	    3
	   / \
	  9  20
	    /  \
	   15   7
	return its minimum depth = 2.
	 * */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

		 public static int minDepth(TreeNode root) {
		   if (root == null) {
		     return 0;
		   }

		   if ((root.left == null) && (root.right == null)) {
		     return 1;
		   }

		   int min_depth = Integer.MAX_VALUE;
		   if (root.left != null) {
		     min_depth = Math.min(minDepth(root.left), min_depth);
		   }
		   if (root.right != null) {
		     min_depth = Math.min(minDepth(root.right), min_depth);
		   }

		   return min_depth + 1;
		 }
		
		 
		 public class TreeNode {
			      int val;
			      TreeNode left;
			      TreeNode right;
			      TreeNode(int x) { val = x; }
			  }

}
