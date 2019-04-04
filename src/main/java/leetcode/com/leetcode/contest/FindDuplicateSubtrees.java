package leetcode.com.leetcode.contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubtrees {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode a = new TreeNode(2);
		TreeNode b = new TreeNode(3);
		TreeNode c = new TreeNode(4);
		TreeNode d = new TreeNode(2);
		TreeNode e = new TreeNode(4);		
		TreeNode last = new TreeNode(4);
		
		root.left = a;
		root.right = b;
		a.left = c;
		b.left = d;
		b.right = e;
		d.left = last;
	}
	
public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

	
	return null;
        
    }
}

