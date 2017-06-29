package leetcode.com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;


public class RemoveDulpicatesfromArrays {
	/*
	 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
Do not allocate extra space for another array, you must do this in place with constant memory.
For example,
Given input array nums = [1,1,2],
Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
	 */

	public static void main(String[] args) {
		int[] nums = {1,1,2,2,3,4,4,4,5,5,5,5,5,6,7};
		
		System.out.println(removeDuplicates(nums));
	}
public static int removeDuplicates1(int[] nums) {
	for(int i=0; i<nums.length-1;i++){
		while(nums[i] == nums[i+1])
				nums = ArrayUtils.removeElement(nums, nums[i]);
	}
	return nums.length;
    }
public static int removeDuplicates2(int[] nums) {
	Set<Integer> numsSet = new HashSet<Integer>();
	List<Integer> numList = new ArrayList<Integer>();
	for(int x: nums){
		if(!numsSet.add(x)){
			numList.add(x);
		}
	}
	System.out.println(numsSet);
	return numsSet.size();
    }
public static int removeDuplicates(int[] nums) {
	if (nums.length==0) return 0;
    int j=0;
    for (int i=0; i<nums.length; i++)
        if (nums[i]!=nums[j]) 
        	nums[++j]=nums[i];
    return ++j;
    }
}
