package programcreek.simplepointer;

public class IsSubsequence {
/*392. Is Subsequence
Given a string s and a string t, check if s is subsequence of t.

You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
s = "abc", t = "ahbgdc"

Return true.

Example 2:
s = "axc", t = "ahbgdc"

Return false.

Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?

Credits:
Special thanks to @pbrother for adding this problem and creating all test cases.*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "axc", t = "ahbgdc";
		System.out.println(isSubsequence(s,t));
	}
	public static boolean isSubsequence(String s, String t) {
	    if(s.length()==0)
	        return true;
	 
	    int i=0;
	    int j=0;    
	    while(i<s.length() && j<t.length()){
	        if(s.charAt(i)==t.charAt(j)){
	            i++;
	        }
	 
	        j++;
	 
	        if(i==s.length())
	            return true;
	    }
	 
	    return false;
	}
}
