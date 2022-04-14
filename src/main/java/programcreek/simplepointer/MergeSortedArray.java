package programcreek.simplepointer;

import java.util.Arrays;

public class MergeSortedArray {
/*88. Merge Sorted Array
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,0,0,0};
		int[] b = {2,5,6};
		int m = 3;
		int n = 3;
		System.out.println(Arrays.toString(merge(a,m,b,n)));
	}
	
	public static int[] merge(int A[], int m, int B[], int n) {
		 
        while(m > 0 && n > 0){
            if(A[m-1] > B[n-1]){
                A[m+n-1] = A[m-1];
                m--;
            }else{
                A[m+n-1] = B[n-1];
                n--;
            }
        }
 
        while(n > 0){
            A[m+n-1] = B[n-1];
            n--;
        }
        return A;
    }

}
