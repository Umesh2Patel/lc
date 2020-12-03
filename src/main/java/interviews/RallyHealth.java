package interviews;

public class RallyHealth {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

	
	/*//Write a function that takes a sorted array of integers and an integer value and returns the index at which the value occurs.


/*
TC1:
int[] arr = {1,2,2,3,4,5};
int v = 2;
int p = 0;
int r = arr.length()-1;

solution(arr, p, r, v); // output = 1

TC2:
int[] arr = {-2,-1,0,1,2,3,4,5};
int v = -1;
int p = 0;
int r = arr.length()-1;
solution(arr, p, r, v); // output = 1

TC3:
int[] arr = {-2};
int v = -1;
int p = 0;
int r = arr.length()-1;
solution(arr, p, r, v); // output = -1 (invalid)


TC4:
int[] arr = {-2};
int v = -2;
int p = 0;
int r = arr.length()-1;
solution(arr, p, r, v); // output = -1 (invalid)


First occurrence of the key in the list where duplicate values can occur. Their code should preserve O(log n) time complexity.

int[] arr = {1,2,3,3,3,4,5}
int v = 3
solution (arr, p, r, v) // output = 2

*/

public int solution(int[] arr, int p, int r, int v) {
    int q = (p + r) / 2; //
    if (p > r) return -1;
    else {
        if (arr[q] == v) {
            if (arr[q] == arr[q + 1])
                return q;
        } else if (arr[q] > v)
            return solution(arr, p, q - 1, v);
        else
            return solution(arr, q + 1, r, v);
    }
return 0;
//pytest
//scalatest
//cyprus- javascript
//appium


}

}
