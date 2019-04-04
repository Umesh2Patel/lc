package leetcode.com.leetcode;

public class HammingDistance {
/*
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
Given two integers x and y, calculate the Hamming distance.
Note:
0 ≤ x, y < 231.
Example:
Input: x = 1, y = 4
Output: 2
Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑
The above arrows point to positions where the corresponding bits are different.
 */
	public static void main(String[] args) {
		System.out.println(hammingDistance(1, 4));

	}
	public static int hammingDistance(int x, int y) {
//		String binaryString = Integer.toBinaryString(y);
		int maxBitcount = Math.max(Integer.bitCount(x), Integer.bitCount(y));
		String xStr = intToBinary(x, maxBitcount);
		String yStr = intToBinary(y, maxBitcount);
		int count = 0;
		for(int i=0;i<maxBitcount;i++){
			if(xStr.charAt(i)!=yStr.charAt(i)) count++;
		}
		
		return count;
	        
	    }
	public static String intToBinary (int n, int numOfBits) {
		int count = Integer.bitCount(n);//to know bitcount
		   String binary = "";
		   for(int i = 0; i < numOfBits; ++i, n/=2) {   //  n/=2 is same as n = n/2 
		      switch (n % 2) {
		         case 0:
		            binary = "0" + binary;
		         case 1:
		            binary = "1" + binary;
		      }
		   }

		   return binary;
		}
}
