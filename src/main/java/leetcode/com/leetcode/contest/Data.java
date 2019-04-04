package leetcode.com.leetcode.contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Data {
	List<Integer> tree; //Serialized version of post-order traversal
	HashMap<Integer,List<Integer>> mp;
	List<List<Integer>> duplcs;
	
	public Data(List<Integer> t){
		tree = t;
		mp = new HashMap<Integer,List<Integer>>();
		duplcs = new ArrayList<List<Integer>>();
	}
}
