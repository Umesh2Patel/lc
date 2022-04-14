package programcreek.simplepointer;

public class MinimizeSizeSubArray {
	/*Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example: 

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
Follow up:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 
*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,3,1,2,4,3};
		System.out.println(minSubArrayLen(7, nums));

	}
	public static int minSubArrayLen(int s, int[] nums) {
	    if(nums==null || nums.length==1)
	        return 0;
	 
	    int result = nums.length;
	 
	    int start=0;
	    int sum=0;
	    int i=0;
	    boolean exists = false;
	 
	    while(i<=nums.length){
	        if(sum>=s){
	            exists=true; //mark if there exists such a subarray 
	            if(start==i-1){
	                return 1;
	            }
	 
	            result = Math.min(result, i-start);
	            sum=sum-nums[start];
	            start++;
	 
	        }else{
	            if(i==nums.length)
	                break;
	            sum = sum+nums[i];
	            i++;    
	        }
	    }
	 
	    if(exists)
	        return result;
	    else
	        return 0;
	}
}
