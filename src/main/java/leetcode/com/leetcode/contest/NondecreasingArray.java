package leetcode.com.leetcode.contest;

import java.awt.peer.CheckboxMenuItemPeer;

import com.thoughtworks.selenium.webdriven.commands.Check;

/*
 * Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).

Example 1:
Input: [4,2,3]
Output: True
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.

Example 2:
Input: [4,2,1]
Output: False
Explanation: You can't get a non-decreasing array by modify at most one element.
Note: The n belongs to [1, 10,000].
 */

public class NondecreasingArray {

	public static void main(String[] args) {
		int[] nums = {2,3,3,2,4};
		int[] nums1 = {4,2,3};
		int[] nums2 = {3,4,2,3};
		int[] nums3 = {1,2,4,5,3};
		System.out.println(checkPossibility(nums));
		System.out.println(checkPossibility(nums1));
		System.out.println(checkPossibility(nums2));
		System.out.println(checkPossibility(nums3));
	}

	public static boolean checkPossibility(int[] nums) {
		int b = 0;
		int count = 0;
		while( (count < 2) && nums.length - 1 > b){
		     if(nums[b] > nums[b+1]){
		    	 count ++;
		    	 if(b==0 && nums[b+1] < nums[b-1]) nums[b] = nums[b+1];
//		    	 else if(b == && nums[b+1] < nums[b-1]) nums[b] = nums[b+1];
		    	 else if(b > 1 && b < nums.length-2 && nums[b+1] < nums[b-1]){
		    		 nums[b+1] = nums[b+2];
		    	 }else
		    	 nums[b] = nums[b+1];
		    	 if(b != 0) b--;
		    	 else b++;
		     }else b++;
		}
		if(count > 1) return false;
		return true;        
    }
	
//	public static boolean isOrdered(int[] array, int index){
//		boolean count = 0;
//	    if(index == array.length - 1) return true;
//	    if(array[index] > array[index + 1]){
//	    		count++;
//	    		return false;
//	    }
//	    return isOrdered(array, index + 1);
//	} 
}
