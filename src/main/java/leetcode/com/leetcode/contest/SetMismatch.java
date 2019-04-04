package leetcode.com.leetcode.contest;

import java.util.Arrays;

public class SetMismatch {
	
	/*
	 * contest 42
	 * The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.

Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.
	 *
	 *Example 1:
	Input: nums = [-1,0,1,2,2,4]
	Output: [2,3]
	 */

	public static void main(String[] args) {
		int[] nums1 = {3,2,2};
		int[] nums2 = {1,2,2,4};
		int[] nums3 = {3,2,3,4,6,5};
		int[] nums = {5,3,2,2,7,4,8,9,6};
		
		int[] R = findErrorNums(nums);

	}
	
	    public static  int[] findErrorNums(int[] nums) {
			return nums;
	    	    
	        
	    }
	

}
