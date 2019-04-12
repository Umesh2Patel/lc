package programcreek.arraystring.simplepointer;

import java.util.Arrays;

public class TwoSumll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		
		int[] indices = twoSum(nums, target);
		System.out.println(Arrays.toString(indices));
	}
	
	public static int[] twoSum(int[] numbers, int target) {
		if (numbers == null || numbers.length == 0)
			return null;
	 
		int i = 0;
		int j = numbers.length - 1;
	 
		while (i < j) {
			int x = numbers[i] + numbers[j];
			if (x < target) {
				++i;
			} else if (x > target) {
				j--;
			} else {
				return new int[] { i + 1, j + 1 };
			}
		}
	 
		return null;
	}


}
