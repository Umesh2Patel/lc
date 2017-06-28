package leetcode.com.leetcode;

public class LongestCommonPrefix {
	/*

14. Longest Common Prefix
Write a function to find the longest common prefix string amongst an array of strings.
	 */

	public static void main(String[] args) {
		
		String[] strs = {"umesh","umeshp","umeshm","umespatel"};
		System.out.println(longestCommonPrefix(strs));
	}
	
public static String longestCommonPrefix(String[] strs) {
	if(strs == null || strs.length == 0)    return "";
    String pre = strs[0];
    int i = 1;
    while(i < strs.length){
        while(strs[i].indexOf(pre) != 0){
//        	System.out.println("before: "+pre);
            pre = pre.substring(0,pre.length()-1);
//        	System.out.println("after: "+pre);
        }
        
        i++;
    }
    return pre;  
    }

}
