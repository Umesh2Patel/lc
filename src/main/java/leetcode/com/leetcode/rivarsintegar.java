package leetcode.com.leetcode;

public class rivarsintegar {
/*	Reverse digits of an integer.

	Example1: x = 123, return 321
	Example2: x = -123, return -321
	Note:
	The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(0));
//		Math.abs(-2147483648) java
//		System.out.println(reverse(321));
	}
public static int reverse(int x) {
	boolean negativeNum = false;
	String xStr;
	if(x < 0){
		negativeNum = true;
		xStr = String.valueOf(x).substring(1);
	}else
		xStr = String.valueOf(x);
	
	String revStr = "";
	char a;
	for(int i=0; i< xStr.length(); i++){
		a = xStr.charAt(xStr.length()-i-1);
		revStr += a;
	}
	if(Long.valueOf(revStr) > Integer.MAX_VALUE)
		return 0;
	else if(negativeNum)
		return -Integer.valueOf(revStr);
	else
		return Integer.valueOf(revStr);
    }

/* litkode solution.
 * public static int reverse(int x) {
	int result = 0;

    while (x != 0)
    {
        int tail = x % 10;
        int newResult = result * 10 + tail;
        if ((newResult - tail) / 10 != result)
        { return 0; }
        result = newResult;
        x = x / 10;
    }

    return result;
    }*/

}
