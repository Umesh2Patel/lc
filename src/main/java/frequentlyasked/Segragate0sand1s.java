package frequentlyasked;

import java.util.Arrays;

public class Segragate0sand1s {


	public static void main(String[] args) {
		// How to sort array of elements arr ={1,0,0,1,1,0} as arr ={0,0,0,1,1,1} with out using 2 for loops and sort method?
		
		int arr[] = new int[] {1,0,0,1,1,0};
		int arr_size = arr.length;
		segregate0and1(arr, arr_size);
		
		System.out.println("Array after segragation is " + Arrays.toString(arr));

	}

	private static void segregate0and1(int[] arr, int size) {
		// Function to put all 0s on left and all 1s on right
		
		//Initialize left and right indexes
		int left = 0;
		int right = size -1;
		
		while(left < right)
		{
			//Increment left index while we see 0 at left
			while(arr[left] == 0 && left < right)
				left++;
			
			//Decrement right index while we see 1 at right
			while(arr[right] == 1 && left < right)
				right--;
			
			/*If left is smaller than right then there is a 1 at left
            and a 0 at right.  Exchange arr[left] and arr[right] */
			if(left < right)
			{
				arr[left] = 0;
				arr[right] = 1;
				left++;
				right--;
			}
			
		}
		
		
		
	}

}
