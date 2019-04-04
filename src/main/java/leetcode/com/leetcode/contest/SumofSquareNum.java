package leetcode.com.leetcode.contest;



public class SumofSquareNum {
/*
 * Contest 39
 * 
 * Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.
 * 
Example 1:
Input: 5
Output: True
Explanation: 1 * 1 + 2 * 2 = 5
Example 2:
Input: 3
Output: False
 */
	public static void main(String[] args) {

		System.out.println(judgeSquareSum(0));
		System.out.println(judgeSquareSum(1));
		System.out.println(judgeSquareSum(2));
		System.out.println(judgeSquareSum(3));
		System.out.println(judgeSquareSum(4));
		System.out.println(judgeSquareSum(5));
		System.out.println(judgeSquareSum(6));
		System.out.println(judgeSquareSum(7));
		System.out.println(judgeSquareSum(8));
		System.out.println(judgeSquareSum(9));
		System.out.println(judgeSquareSum(10));
		System.out.println(judgeSquareSum(11));
		System.out.println(judgeSquareSum(12));
	}
	public static boolean judgeSquareSum(int c) {
		
//		if((c-1)%4==0) return true;
			System.out.println("c :"+ c + " c%1 ="+ c%1+ " c%2 ="+ c%2 +" c%3 =" + c%3 );
			
//			if(c%1==0 && c )
		
		for(int i=0; i<=c; i++)
            for(int j=0; j<=c; j++)
                if(i*i+j*j == c) return true;
    return false;
        
    }
}
