package leetcode.com.leetcode;

import java.util.Arrays;

public class MaximumSubarray {
	
	/*
	 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
	 * 
	 */

	public static void main(String[] args) {
//		int[] A = {-2,1,-3,4,-1,2,1,-5,4};
//		int[] A = {1,12,-5,-6,50,3};
//		int[] A = {0,1,1,3,3};
//		int[] A = {4,0,4,3,3};
//		int[] A = {1,12,-5,-6,50,3};
		int[] A = {1,12,-5,-6,50,3};
		int k = 4;
		double maxSoFar = findMaxAverage(A,k);
		
		System.out.println(maxSoFar);
		

	}
	public static double maxSubArray(int[] nums, int k) {
		int sum = 0;
        for(int i = 0; i < k; i++) {
            sum += nums[i];
        }
        
        int maxSum = sum;
        for(int i = 0, j = k; j < nums.length; i++, j++) {
            sum = sum - nums[i] + nums[j];
            maxSum = Math.max(sum, maxSum);
        }
        
        return ((double) maxSum) / ((double) k);
	} 
	public static double findMaxAverage(int[] A, int k) {
        double maxEndhere = sumOfKElement(A,0,k);
        double maxSoFar = maxEndhere/k ;
        for (int i=1;i<A.length-k+1;++i){
            maxEndhere= Math.max(maxEndhere,sumOfKElement(A, i, k));
            maxSoFar = Math.max(maxSoFar, maxEndhere/k);
        }
        return maxSoFar;
    }
    public static double sumOfKElement (int[] A, int I, int k) {
    	double sum =0;
    	for(int i =I; i<Math.min(k+I , A.length); i++)
			sum += A[i];
		return sum;
	}
}
