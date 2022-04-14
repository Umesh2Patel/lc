package programcreek.simplepointer;

import java.util.Arrays;

public class RemoveDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,1,2,2,2,2,2,2};
		System.out.println(removeDuplicates(A));

	}
	
	public static int removeDuplicates(int[] A) {
		if (A.length < 2)
			return A.length;
	 
		int j = 0;
		int i = 1;
	 
		while (i < A.length) {
			if (A[i] != A[j]) {
				j++;
				A[j] = A[i];
			}
	 
	                i++;
		}
		System.out.println(Arrays.toString(A));
		return j + 1;
	}
}
