package frequentlyasked;

public class PrimeCheck {
	
	public static void main (String[] arg){
		
		int n = 13;
		System.out.println("The Number " + n + " is prime number: " + isPrime(n));		
	}

	
	 public static boolean isPrime(int n){
		 if (n < 2) return false; // 0 and 1 are not prime, but 2 is prime 
		 
		 for(int i = 2; i < n; i ++){
			 if(n%i == 0){
				 return false;
			 }
		 }
		return true;
	 }
}
	