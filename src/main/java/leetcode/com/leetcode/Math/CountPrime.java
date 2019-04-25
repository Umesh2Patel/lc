package leetcode.com.leetcode.Math;

public class CountPrime {
	/*204. Count Primes- Easy- Count the number of prime numbers less than a non-negative number, n.
Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countPrimes(10));
		System.out.println(countPrimes(13));
		System.out.println(countPrimes(19));
		System.out.println(countPrimes(234));
	}
	
	public static int countPrimes(int n) {
		if (n <= 2)
			return 0;
	 
		// init an array to track prime numbers
		boolean[] primes = new boolean[n];
		for (int i = 2; i < n; i++)
			primes[i] = true;
	 
		for (int i = 2; i <= Math.sqrt(n - 1); i++) {
		// or for (int i = 2; i <= n-1; i++) {
			if (primes[i]) {
				for (int j = i + i; j < n; j += i)
					primes[j] = false;
			}
		}
	 
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (primes[i])
				count++;
		}
	 
		return count;
	}
	

}
