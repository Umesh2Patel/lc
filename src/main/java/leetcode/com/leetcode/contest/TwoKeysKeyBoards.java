package leetcode.com.leetcode.contest;

public class TwoKeysKeyBoards {

	public static void main(String[] args) {

		System.out.println(minSteps(1000));
	}
	
public static int minSteps(int n) {
	return n == 1 ? 0 : 1 + minSteps(1, 1, n);
    }
private static int minSteps(int m, int clip, int n) {
    if(m == n) {
        return 0;
    }
    
    if(m > n) {
    // -1 signals that the key sequence followed so far is invalid
        return -1;
    }
    
    if(m == clip) {
    //avoid a sequence with consecutive copies
        int pasteCost = minSteps(m + clip, clip, n);
        return pasteCost == -1 ? -1 : 1 + pasteCost;
    }
    
    int copyCost = minSteps(m, m, n);
    int pasteCost = minSteps(m + clip, clip, n);
    if(copyCost == -1 && pasteCost == -1) {
        return -1;
    }
    else if(copyCost == -1) {
        return 1 + pasteCost;
    }
    else if(pasteCost == -1) {
        return 1 + copyCost;
    }
    else {
        return 1 + Math.min(copyCost, pasteCost);    
    }
}


}
