package programcreek.arraystring.simplepointer;

import java.util.Arrays;

public class TwoSum {
	/*Given an array of integers, return indices of the two numbers such that they add up to a specific target.
	You may assume that each input would have exactly one solution, and you may not use the same element twice.
	Given nums = [2, 7, 11, 15], target = 9,
	Because nums[0] + nums[1] = 2 + 7 = 9,
	return [0, 1]*/
	public static void main(String[] args) {
		int[] nums = {3,2,4};
		int target = 6;
		
		int[] indices = twoSum(nums, target);
		System.out.println(Arrays.toString(indices));
	}

	private static int[] twoSum(int[] nums, int target) {
		for(int i=0; i< nums.length-1; i++){
			for(int j=0; j< nums.length; j++){
				if(nums[i]+nums[j] == target && i != j){
					int[] indices = {i,j} ;
					return indices;
				}	
			}
		}
		return null;
	}

}
