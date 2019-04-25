package leetcode.com.leetcode.Math;

public class ExcelColumnNum {
	/*171. Excel Sheet Column Number Easy
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
Example 1:

Input: "A"
Output: 1
Example 2:

Input: "AB"
Output: 28
Example 3:

Input: "ZY"
Output: 701
*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(titleToNumber("A"));
		System.out.println(titleToNumber("D"));
		System.out.println(titleToNumber("DG"));
	}
	public static int titleToNumber(String s) {
	    if(s==null || s.length() == 0){
	        throw new IllegalArgumentException("Input is not valid!");
	    }
	 
	    int result = 0;
	    int i = s.length()-1;
	    int t = 0;
	    while(i >= 0){
	        char curr = s.charAt(i);
	        result = result + (int) Math.pow(26, t) * (curr-'A'+1);
	        t++;
	        i--;
	    }
	 
	    return result;
	}
}
