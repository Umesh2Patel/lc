package leetcode.com.leetcode;

public class Candy {
	
	/*
	 * here are N children standing in a line. Each child is assigned a rating value.

	You are giving candies to these children subjected to the following requirements:
	
	Each child must have at least one candy.
	Children with a higher rating get more candies than their neighbors.
	What is the minimum candies you must give?
	
	Example 1:
	
	Input: [1,0,2]
	Output: 5
	Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
	Example 2:
	
	Input: [1,2,2]
	Output: 4
	Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
	             The third child gets 1 candy because it satisfies the above two conditions.
	 * */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] rat1 = {1,0,2};
		int[] rat2 = {1,2,2};
		System.out.println(candy(rat1));
		System.out.println(candy(rat2));
//		System.out.println(candy("Hello"));

	}
	
	public static int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
		return 0;
	}
 
	int[] candies = new int[ratings.length];
	candies[0] = 1;
 
	//from let to right
	for (int i = 1; i < ratings.length; i++) {
		if (ratings[i] > ratings[i - 1]) {
			candies[i] = candies[i - 1] + 1;
		} else { 
			// if not ascending, assign 1
			candies[i] = 1;
		}
	}
 
	int result = candies[ratings.length - 1];
 
	//from right to left
	for (int i = ratings.length - 2; i >= 0; i--) {
		int cur = 1;
		if (ratings[i] > ratings[i + 1]) {
			cur = candies[i + 1] + 1;
		}
 
		result += Math.max(cur, candies[i]);
		candies[i] = cur;
	}
 
	return result;
    }

}
