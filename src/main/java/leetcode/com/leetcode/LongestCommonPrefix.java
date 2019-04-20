package leetcode.com.leetcode;

public class LongestCommonPrefix {
	/*

14. Longest Common Prefix
Write a function to find the longest common prefix string amongst an array of strings.
	 */

	public static void main(String[] args) {
		
		String[] strs = {"umesh","umeshp","umeshm","umespatel"};
		System.out.println("longestCommonPrefix: " + longestCommonPrefix(strs));
	}
	
public static String longestCommonPrefix(String[] strs) {
	if(strs == null || strs.length == 0)    return "";
    String pre = strs[0];
    for(int i = 1; i < strs.length; i++)
    	while(strs[i].indexOf(pre) != 0)
            pre = pre.substring(0,pre.length()-1);                
    return pre;  
    }

}
