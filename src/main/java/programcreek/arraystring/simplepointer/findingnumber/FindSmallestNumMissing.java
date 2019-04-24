package programcreek.arraystring.simplepointer.findingnumber;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author umeshkhunt
 * 
 *         You are given an unsorted array with both positive and negative
 *         elements. You have to find the smallest positive number missing from
 *         the array in O(n) time using constant extra space. example: give
 *         array {2,3} result will be 1. OR {1,2,3} result will be 4.
 *
 */
public class FindSmallestNumMissing {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 0, -1, -2 };
		
		
		
//		int out = firstMissingPositiveNumber(arr);
//		System.out.println(out);
//		FindSmallestNumMissing find = new FindSmallestNumMissing();
		
		int output = firstMissingPositiveNum(arr);
		
		System.out.println("Given unsorted array: " + Arrays.toString(arr));
		System.out.println("The smallest positive number missing from the array is: " + output);
	}

//	private static int firstMissingPositiveNumber(int[] arr) {
//		Arrays.sort(arr);
//		for(int i=0; i< arr.length; i++){
//			if(arr[i]>0){
//				if(arr[i] != arr[i-1] +1)
//					return arr[i-1] + 1;
//			}
//		}
//		
//		return arr[arr.length-1]+1;
//	}

	private static int firstMissingPositiveNum(int[] arr) {
		// TODO 
//		HashSet<Integer> inOrderTs = storeAsTree(arr);
		Set<Integer> inOrderTs = new HashSet<Integer>();
		for(int num : arr)
			inOrderTs.add(num);
		
		int size = inOrderTs.size();
		
		for(int i = 0; i < size; i++)		
			if(!(inOrderTs.contains(i+1))) return i+1;				
		return size+1;
	}

//	private static HashSet<Integer> storeAsTree(int[] arr) {
//		// TODO Storing only positive values in TreeSet in natural order.
//
////		TreeSet<Integer> ts = new TreeSet<Integer>();
//		HashSet<Integer> ts = new HashSet<Integer>();
//		for (int i = 0; i < arr.length; i++) 
//			if (arr[i] > 0) ts.add(arr[i]); // Storing only positive values in TreeSet in
//		return ts;
//	}
}
