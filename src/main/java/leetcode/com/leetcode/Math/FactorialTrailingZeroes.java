package leetcode.com.leetcode.Math;

public class FactorialTrailingZeroes {
	/*172. Factorial Trailing Zeroes Easy
Given an integer n, return the number of trailing zeroes in n!.

Example 1:

Input: 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: 5
Output: 1
Explanation: 5! = 120, one trailing zero.*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(trailingZeroes(3));
		System.out.println(trailingZeroes(5));
		System.out.println(trailingZeroes(6));
		System.out.println(trailingZeroes(45));
	}
	public static int trailingZeroes(int n) {
		if (n < 0)
			return -1;
	 
		int count = 0;
		for (long i = 5; n / i >= 1; i *= 5) {
			count += n / i;
		}
	 
		return count;
	}
}
