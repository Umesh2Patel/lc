package programcreek.arraystring.simplepointer;

import java.util.Arrays;
import java.util.HashSet;

public class IntersectionOf2Arrays {
/*349. Intersection of Two Arrays
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Note:

Each element in the result must be unique.
The result can be in any order.
*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};
		System.out.println(Arrays.toString(intersection(nums1, nums2)));
	}
	public static int[] intersection(int[] nums1, int[] nums2) {
	    HashSet<Integer> set1 = new HashSet<Integer>();
	    for(int i: nums1){
	        set1.add(i);
	    }
	 
	    HashSet<Integer> set2 = new HashSet<Integer>();
	    for(int i: nums2){
	        if(set1.contains(i)){
	            set2.add(i);
	        }
	    }
	 
	    int[] result = new int[set2.size()];
	    int i=0;
	    for(int n: set2){
	        result[i++] = n;
	    }
	 
	    return result;
	}

}
