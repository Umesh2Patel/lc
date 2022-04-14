package programcreek.binarysearch;

/**
 * Created by umeshkhunt on 12/2/20.
 */
public class MedianOf2SortedArrays {
    /*
    * question- There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
    *
    * Solution-
    * This problem can be converted to the problem of finding kth element, k is (A's length + B' Length)/2.
      If any of the two arrays is empty, then the kth element is the non-empty array's kth element. If k == 0, the kth element is the first element of A or B.

      For normal cases(all other cases), we need to move the pointer at the pace of half of the array size to get O(log(n)) time.
    *
    ** mean vs median **
    * Input  : a[] = {1, 3, 4, 2, 6, 5, 8, 7}
        Output : Mean = 4.5
                 Median = 4.5
        Sum of the elements is 1 + 3 + 4 + 2 + 6 +
        5 + 8 + 7 = 36
        Mean = 36/8 = 4.5
        Since number of elements are even, median
        is average of 4th and 5th largest elements.
        which means (4 + 5)/2 = 4.5

        Input  : a[] = {4, 4, 4, 4, 4}
        Output : Mean = 4
                 Median = 4
    *
    *
    * */



}
