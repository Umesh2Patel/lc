package leetcode.com.leetcode;

/**
 * Created by umeshkhunt on 3/29/19.
 */
public class sqrt {

    public static void main(String[] args){
    	int x = 4;
        
    	System.out.println(sqrt_of(x));
        
        
    }

	private static int sqrt_of(int x) {
		return (int) (Math.pow(x, 0.5));
	}

	
}
