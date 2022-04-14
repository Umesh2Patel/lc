package programcreek.simplepointer;

public class WiggleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,5,2,1,6,4};
		wiggleSort(nums);
	}
	
	public static void wiggleSort(int[] nums) {
	    if (nums == null || nums.length <= 1) {
	        return;
	    }
	 
	    for (int i = 1; i < nums.length; i++) {
	        if (i % 2 == 1) {
	            if (nums[i - 1] > nums[i]) {
	                swap(nums, i - 1, i);
	            }
	        } else {
	            if (nums[i - 1] < nums[i]) {
	                swap(nums, i - 1, i);
	            }
	        }
	    }
	}
	 
	private static void swap(int[] nums, int i, int j) {
	    int t = nums[i];
	    nums[i] = nums[j];
	    nums[j] = t;
	}

}
