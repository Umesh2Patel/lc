package leetcode.com.leetcode.Math;

public class ExcelColumnTitle {
	
	/*168. Excel Sheet Column Title  Easy
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...
Example 1:

Input: 1
Output: "A"
Example 2:

Input: 28
Output: "AB"
Example 3:

Input: 701
Output: "ZY"*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convertToTitle(1));
		System.out.println(convertToTitle(2));
		System.out.println(convertToTitle(5));
		System.out.println(convertToTitle(23));
		System.out.println(convertToTitle(35));
	}
	public static String convertToTitle(int n) {
	    if(n <= 0){
	        throw new IllegalArgumentException("Input is not valid!");
	    }
	 
	    StringBuilder sb = new StringBuilder();
	 
	    while(n > 0){
	        n--;
	        char ch = (char) (n % 26 + 'A');
	        n /= 26;
	        sb.append(ch);
	    }
	 
	    sb.reverse();
	    return sb.toString();
	}

}
