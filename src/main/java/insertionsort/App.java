package insertionsort;

public class App {

	public static void main(String[] args) {
		int [] myArray = insertionSort(new int [] {9,8,6,5,34,5,65,2});


	}

	private static int[] insertionSort(int[] A) {
		for(int i=1; i< A.length; i++ ){
			int element = A[i];
			int j = i-1;
			while(j >= 0 && A[j] > element){
				A[j+1] = A[j];
				j--;
			}
			A[j+1]= element;
			
		}
		return A;
	}

}
