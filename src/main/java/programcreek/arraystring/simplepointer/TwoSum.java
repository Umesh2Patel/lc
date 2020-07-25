package programcreek.arraystring.simplepointer;

import java.util.Arrays;
import java.util.HashMap;

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
		throw new IllegalArgumentException("No two sum solution");
	}
	public int[] twoSum2(int[] nums, int target) {
	    if(nums==null || nums.length<2)
	        return new int[]{0,0};
	 
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for(int i=0; i<nums.length; i++){
	        if(map.containsKey(nums[i])){
	            return new int[]{map.get(nums[i]), i};
	        }else{
	            map.put(target-nums[i], i);
	        }
	    }
	 
	    return new int[]{0,0};
	}
}
