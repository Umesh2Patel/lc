package leetcode.com.leetcode.Math;

public class FindNthDigit {
/*400. Nth Digit Easy
Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

Note:
n is positive and will fit within the range of a 32-bit signed integer (n < 231).

Example 1:

Input:
3

Output:
3
Example 2:

Input:
11

Output:
0

Explanation:
The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findNthDigit(3));
		System.out.println(findNthDigit(11));
		System.out.println(findNthDigit(10));
		System.out.println(findNthDigit(2));
		System.out.println(findNthDigit(12));
		System.out.println(findNthDigit(0));
	}
	public static int findNthDigit(int m) {
	    long n=m; // convert int to long 
	    long start=1,  len=1,  count=9;
	 
	    while(n>len*count){
	        n=n-len*count;
	        len++;
	        count=count*10;
	        start=start*10;
	    }
	 
	    // identify the number
	    start = start + (n-1)/len;
	 
	    // identify the digit
	    return String.valueOf(start).charAt((int)((n-1)%len))-'0';
	}
}
