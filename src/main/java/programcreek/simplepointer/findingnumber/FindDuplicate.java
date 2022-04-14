package programcreek.simplepointer.findingnumber;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,3,5,2,2,1,6,4};
		System.out.println(findDuplicate(nums));
	}

	private static int findDuplicate(int[] nums) {
		Set<Integer> seen = new HashSet<Integer>();
		// TODO Auto-generated method stub
		for(int num : nums)
			if(!seen.add(num))
				return num;
		return -1;
	}

}
