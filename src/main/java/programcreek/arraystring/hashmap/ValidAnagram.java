package programcreek.arraystring.hashmap;

import java.util.Arrays;

public class ValidAnagram {
	
	/*242. Valid Anagram
Easy
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "anagram";
		String t = "nagaram";
		System.out.println(isAnagram(s, t));
		System.out.println(isAnagram2(s, t));
	}
	
	public static boolean isAnagram(String s, String t) {
	    if (s.length() != t.length()) {
	        return false;
	    }
	    int[] counter = new int[26];
	    for (int i = 0; i < s.length(); i++) {
//	    	System.out.println(s.charAt(i) - 'a');
//	    	System.out.println(t.charAt(i) - 'a');
//	    	System.out.println(s.charAt(i) );
//	    	System.out.println(t.charAt(i));
//	    	System.out.println(Character.getNumericValue('a'));
//	    	System.out.println(Character.getNumericValue('n'));	    	
	        counter[s.charAt(i) - 'a']++;
	        counter[t.charAt(i) - 'a']--;
	    }
	    for (int count : counter) {
	        if (count != 0) {
	            return false;
	        }
	    }
	    return true;
	}
	
	public static boolean isAnagram2(String s, String t) {
	    if (s.length() != t.length()) {
	        return false;
	    }
	    char[] str1 = s.toCharArray();
	    char[] str2 = t.toCharArray();
	    Arrays.sort(str1);
	    Arrays.sort(str2);
	    return Arrays.equals(str1, str2);
	}

}
