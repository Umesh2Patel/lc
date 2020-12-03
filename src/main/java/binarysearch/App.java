package binarysearch;

import java.util.Arrays;

public class App {

	public static void main(String[] args) {
		int[] a = {4,48,4,28,34,76,9,3};	
		Arrays.sort(a);
		System.out.println(recursiveBinarySearch(a, 0, a.length-1 , 48));
//		System.out.println(binarySearch(a, 48));

	}
	
	public static int binarySearch(int[] a, int x){
		int p=0;
		int r= a.length -1;
		
		while(p<=r){
			int q = (p+r)/2;
			if(a[q] == x) return q;
			else if(a[q]>x) r=q-1;
			else p=q+1;
		}
		
		return -1;
		
	}
	
	private static int recursiveBinarySearch(int[] a, int p, int r, int x) {
		System.out.println("[ "+ p+ "..." + r + " ]");
		if(p > r) return -1;
		else{
			int q = (p+r)/2;
			if(a[q]==x) 
				return q;
			else if(a[q] > x)
				return recursiveBinarySearch(a, p, q-1, x);
			else
				return recursiveBinarySearch(a, q+1, r, x);
		}
	}

}
