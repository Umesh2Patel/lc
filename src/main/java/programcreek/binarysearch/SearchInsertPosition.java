package programcreek.binarysearch;

public class SearchInsertPosition {
	/*
	* Given a sorted array and a target value, return the index if the target is found.
	* If not, return the index where it would be if it were inserted in order.
	* You may assume no duplicates in the array.
	*
	* Here are few examples.
        [1,3,5,6], 5 -> 2
        [1,3,5,6], 2 -> 1
        [1,3,5,6], 7 -> 4
        [1,3,5,6], 0 -> 0
	* The complexity should be O(log(n)).
	*
	*
	*
	* */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] nums = {1,3,5,6};
        int target = 5;
        System.out.println(searchInsert(nums, target));

	}

    public static int searchInsert(int[] nums, int target) {
        if(target>nums[nums.length-1]){
            return nums.length;
        }

        int l=0;
        int r=nums.length-1;

        while(l<r){
            int m = l+(r-l)/2;
            if(target>nums[m]){
                l=m+1;
            }else{
                r=m;
            }
        }

        return l;
    }
    
    
//    Or similarly, we can write the solution like the following:
    public static int searchInsert1(int[] nums, int target) {
        int i=0; 
        int j=nums.length-1;
     
        while(i<=j){
            int mid = (i+j)/2;
     
            if(target > nums[mid]){
                i=mid+1;
            }else if(target < nums[mid]){
                j=mid-1;
            }else{
                return mid;
            }
        }
     
        return i;
    }

}
