package programcreek.arraystring.simplepointer;

public class WiggleSubsequence {
	/*376. Wiggle Subsequence Medium

A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.

For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.

Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the remaining elements in their original order.

Example 1:

Input: [1,7,4,9,2,5]
Output: 6
Explanation: The entire sequence is a wiggle sequence.
Example 2:

Input: [1,17,5,10,13,15,10,5,16,8]
Output: 7
Explanation: There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].
Example 3:

Input: [1,2,3,4,5,6,7,8,9]
Output: 2
Follow up:
Can you do it in O(n) time?*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,7,4,9,2,5};
		int[] b = {1,17,5,10,13,15,10,5,16,8};
		int[] c = {1,2,3,4,5,6,7,8,9};
		System.out.println(wiggleMaxLength(a));
		System.out.println(wiggleMaxLength(b));
		System.out.println(wiggleMaxLength(c));
		System.out.println(wiggleMaxLength2(a));
		System.out.println(wiggleMaxLength2(b));
		System.out.println(wiggleMaxLength2(c));
	}
	
	 	private static int calculate(int[] nums, int index, boolean isUp) {
	        int maxcount = 0;
	        for (int i = index + 1; i < nums.length; i++) {
	            if ((isUp && nums[i] > nums[index]) || (!isUp && nums[i] < nums[index]))
	                maxcount = Math.max(maxcount, 1 + calculate(nums, i, !isUp));
	        }
	        return maxcount;
	    }

	    public static int wiggleMaxLength(int[] nums) {
	        if (nums.length < 2)
	            return nums.length;
	        return 1 + Math.max(calculate(nums, 0, true), calculate(nums, 0, false));
	    }
	    
//	    Approach #5 Greedy Approach [Accepted]
	    public static int wiggleMaxLength2(int[] nums) {
	        if (nums.length < 2)
	            return nums.length;
	        int prevdiff = nums[1] - nums[0];
	        int count = prevdiff != 0 ? 2 : 1;
	        for (int i = 2; i < nums.length; i++) {
	            int diff = nums[i] - nums[i - 1];
	            if ((diff > 0 && prevdiff <= 0) || (diff < 0 && prevdiff >= 0)) {
	                count++;
	                prevdiff = diff;
	            }
	        }
	        return count;
	    }

}
