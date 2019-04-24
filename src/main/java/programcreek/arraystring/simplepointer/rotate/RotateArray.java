package programcreek.arraystring.simplepointer.rotate;

public class RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,3,5,2,2,1,6,4};
		rotate1(nums, 3);
//		System.out.println();
	}
	public static void rotate(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }
	public static void rotate1(int[] nums, int k) {
		int j ;
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
        	j = (i + k) % nums.length;
            a[j] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

}
