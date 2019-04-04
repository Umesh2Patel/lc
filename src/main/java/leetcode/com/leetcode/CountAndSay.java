package leetcode.com.leetcode;

public class CountAndSay {
	/*
	 * The count-and-say sequence is the sequence of integers with the first
	 * five terms as following: 
	 * 1. 1 
	 * 2. 11 
	 * 3. 21 
	 * 4. 1211 
	 * 5. 111221 
	 * 
	 * 1 is read off as "one 1" or 11.
	 * 11 is read off as "two 1s" or 21. 
	 * 21 is read off as "one 2, then one 1" or 1211.
	 * Given an integer n, generate the nth term of
	 * the count-and-say sequence. Note: Each term of the sequence of integers
	 * will be represented as a string.
	 * 
	 */
	public static void main(String[] args) {
		System.out.println(countAndSay(6));

	}
	public static String countAndSay(int n) {
		if(n==1) return "1";
	    
	    String res = "1";
	    for(int i=2; i<=n; i++) {
	        res = helper(res);
	    }
	    return res;
	}
	public static String helper(String str) {
	    int count = 1;
	    String res = "";
	    
	    for(int i=1; i<str.length(); i++) {
	        if(str.charAt(i) == str.charAt(i-1) )
	            count++;
	        else {
	            res += String.valueOf(count) + str.charAt(i-1);
	            count = 1;
	        }
	    }
	    res += count + str.substring(str.length()-1);
	    return res;
	}
}
