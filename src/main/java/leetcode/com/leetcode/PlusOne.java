package leetcode.com.leetcode;

import java.util.Arrays;

public class PlusOne {
	/*Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
	 The digits are stored such that the most significant digit is at the head of the list, 
	 and each element in the array contain a single digit.
	 You may assume the integer does not contain any leading zero, except the number 0 itself.

	Example 1:
	Input: [1,2,3]
	Output: [1,2,4]
	Explanation: The array represents the integer 123.

	Example 2:
	Input: [4,3,2,1]
	Output: [4,3,2,2]
	Explanation: The array represents the integer 4321.*/

	public static void main(String[] args) {		


		int[] digits = {1,2,3,9};
		System.out.println(Arrays.toString(plusOne(digits)));
//		String str = Arrays.toString(digits).replaceAll("\\[|\\]|,|\\s", "");
//		System.out.println(str);
//		int toInt = Integer.valueOf(str)+1;
//		System.out.println(toInt);
		
				

}
	
	public static int[] plusOne(int[] d) {
		int n = d.length;
	    for(int i=n-1; i>=0; i--) {
	        if(d[i] < 9) {
	            d[i]++;
	            return d;
	        }
	        
	        d[i] = 0;
	    }
	    
	    int[] r = new int [n+1];
	    r[0] = 1;
	    
	    return r;
	}
	
	//does not work
	public static int[] plusOne1(int[] d) {
		if (d[d.length-1] != 9) {
			d[d.length-1]++;
			return d;
		}else {
			String s = Arrays.toString(d).replaceAll("\\[|\\]|,|\\s", "");
			int i = Integer.valueOf(s)+1;
			String r = String.valueOf(i);
			for(int j=r.length()-1; j>0; j--) {
				if(r.charAt(j) != s.charAt(j)) {
					d[j] = r.charAt(j) - '0';
				}
			}
		}
		return d;
	    }

}
