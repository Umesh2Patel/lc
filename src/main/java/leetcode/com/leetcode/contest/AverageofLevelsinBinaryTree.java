package leetcode.com.leetcode.contest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;




public class AverageofLevelsinBinaryTree {
/*
 * Contest 49
 * 
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * Example 1:
		Input:
		    3
		   / \
		  9  20
		    /  \
		   15   7
		Output: [3, 14.5, 11]
		Explanation:
		The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 * 
 */
	public static void main(String[] args) {
		
		Stack mystack = new Stack();
		mystack.add("Str");
		mystack.add(1);
		
		
		
		TreeNode root = new TreeNode(3);
		TreeNode leftL1 = new TreeNode(9);
		TreeNode rightL1 = new TreeNode(20);
		TreeNode leftL2 = new TreeNode(15);
		TreeNode rightL2 = new TreeNode(7);
		
		root.left = leftL1 ;
		root.right = rightL1;
		rightL1.left = leftL2;
		rightL1.right = rightL2;
        
        List<Double> result = averageOfLevels(root);
        System.out.println(result);
		
	}
public static List<Double> averageOfLevels1(TreeNode root) {
	List<Double> result = new ArrayList<Double>();
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    
    if(root == null) return result;
    q.add(root);
    while(!q.isEmpty()) {
        int n = q.size();
        double sum = 0.0;
        for(int i = 0; i < n; i++) {
            TreeNode node = q.poll();
            sum += node.val;
            if(node.left != null) q.offer(node.left);
            if(node.right != null) q.offer(node.right);
        }
        result.add(sum / n);
    }
    return result;      
    }
public static List<Double> averageOfLevels(TreeNode root) {
    List<Double> ll = new LinkedList<Double>();
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.add(root);
    while(!q.isEmpty()){
        int levelNum = q.size();
        double sum=0;
        for(int i=0; i<levelNum; i++) {
            if(q.peek().left != null) q.offer(q.peek().left);
            if(q.peek().right != null) q.offer(q.peek().right);
            sum+=(double)q.poll().val/levelNum;
        }
        ll.add(sum);
    }
    return ll; 
}
//public class TreeNode {
//	int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
// }
}
