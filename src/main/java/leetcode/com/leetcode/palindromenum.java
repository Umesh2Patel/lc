package leetcode.com.leetcode;

public class palindromenum {
	/*
	 * Determine whether an integer is a palindrome. Do this without extra space.
	 */

	public static void main(String[] args) {
		System.out.println(isPalindrome(2147447412));

	}
 public static boolean isPalindrome(int x) {
	if(x<0)
		return false;

	int result = 0;
	int xHolder = x;
	while(x != 0){
		int tail = x%10;		
		int newResult = result * 10 + tail;
		result = newResult;
		x = x/10;
	}
	if(result == xHolder)
		return true;
	else
		return false;
    }
}
