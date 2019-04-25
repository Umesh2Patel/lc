package leetcode.com.leetcode.Math;

import java.util.HashSet;

public class HappyNum {
	/*202. Happy Number Easy
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 

Input: 19
Output: true
Explanation: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isHappy(19));
		System.out.println(isHappy(12));
		System.out.println(isHappy(19));
		System.out.println(isHappy(124));
		System.out.println(isHappy(123));
		System.out.println(isHappy(43));
	}
	
	public static boolean isHappy(int n) {
	    HashSet<Integer> set = new HashSet<Integer>();
	 
	    while(!set.contains(n)){
	        set.add(n);
	 
	        n = getSum(n);
	 
	        if(n==1)
	            return true;
	    }
	 
	    return false;
	}
	 
	public static int getSum(int n){
	    int sum =0;
	    while(n>0){
	        sum+=(n%10)*(n%10);
	        n=n/10;
	    } 
	    return sum;    
	}


}
