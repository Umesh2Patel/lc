package selectionsort;

public class App {

	public static void main(String[] args) {
		int [] myArray = selectionSort(new int [] {9,8,6,5,34,65,2});

	}

	private static int[] selectionSort(int[] A) {
		for(int i=0; i<A.length-1; i++){
			int min = i;
			for(int j=i+1; j<A.length; j++){
				if(A[j] < A[min]){
					min = j;
				}
			}
			int temp = A[i];
			A[i] = A[min];
			A[min] = temp;
		}
		return A;
	}

}
