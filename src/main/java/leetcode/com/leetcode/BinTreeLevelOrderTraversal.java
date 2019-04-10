package leetcode.com.leetcode;

import java.util.*;


public class BinTreeLevelOrderTraversal {
	
	/*
	107. Binary Tree Level Order Traversal II
	Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
	
	For example:
	Given binary tree [3,9,20,null,null,15,7],
			    3
			   / \
			  9  20
			    /  \
			   15   7
	return its bottom-up level order traversal as:
			[
			  [15,7],
			  [9,20],
			  [3]
			]
	 * */
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15); 
		root.right.right = new TreeNode(7); 
		System.out.println(levelOrderBottom(root));
	}
	
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		/*
		 * This solution is nearly identical to the traditional 'Level Order traversal' only difference is the DataStructure used to hold the data. 
		 * Instead of Using an ArrayList and appending each level after the other I used a LinkedList and added each new level to the head of the LinkedList.
		 * */
        if(root == null) return new LinkedList<List<Integer>>();
        List<List<Integer>> levels = new LinkedList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>(); 
        q.add(root);
        
        while(!q.isEmpty()){
            List<Integer> list = new ArrayList<Integer>(); 
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode node = q.remove();
                list.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            ((LinkedList)levels).addFirst(list);
        }
        return levels;
    }
	
	

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
