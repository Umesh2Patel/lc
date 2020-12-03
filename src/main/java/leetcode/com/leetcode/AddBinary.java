package leetcode.com.leetcode;

public class AddBinary {
	
	/*Given two binary strings, return their sum (also a binary string).
The input strings are both non-empty and contains only characters 1 or 0.
Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		String a = "1010";
		String b = "1011";
		String rslt = addBinary(a,b); 
		System.out.println(rslt);

	}
	
public static String addBinary(String a, String b) {
	int i = a.length()-1;
	int j = b.length()-1;
	StringBuilder rslt = new StringBuilder();
	int carry = 0;
	while(i >=0 || j >=0) {
		int A = i >= 0 ? a.charAt(i)-'0' : 0;
		int B = j >= 0 ? b.charAt(j)-'0' : 0;		
		int val = A ^ B ^ carry;
		carry = A+B+carry > 1 ? 1 : 0;
		rslt = rslt.append(val); 
		i--;j--;
	}
	if(carry==1){
		rslt.append(carry);
    }
	return rslt.reverse().toString();
    }
}