package interviews;

import java.util.Arrays;

public class roblox {
	//Imagine we have an image. We'll represent this image as a simple 2D array where every pixel is a 1 or a 0. The image you get is known to have a single rectangle of 0s on a background of 1s.

	//Write a function that takes in the image and returns the coordinates of the rectangle of 0's -- either top-left and bottom-right; or top-left, width, and height.

	//image1 = [
	//[1, 1, 1, 1, 1, 1, 1],
	//[1, 1, 1, 1, 1, 1, 1],
	//[1, 1, 1, 0, 0, 0, 1],
	//[1, 1, 1, 0, 0, 0, 1],
	//[1, 1, 1, 1, 1, 1, 1],
	//]

	//Sample output variations (only one is necessary):

	//findRectangle(image1) =>
	//x: 3, y: 2, width: 3, height: 2
	//2,3 3,5 -- row,column of the top-left and bottom-right corners

	//Other test cases:

	//image2 = [
	//[1, 1, 1, 1, 1, 1, 1],
	//[1, 1, 1, 1, 1, 1, 1],
	//[1, 1, 1, 1, 1, 1, 1],
	//[1, 1, 1, 1, 1, 1, 1],
	//[1, 1, 1, 1, 1, 1, 0],
	//]

	//findRectangle(image2) =>
	//x: 6, y: 4, width: 1, height: 1
	//4,6 4,6

	//image3 = [
	//[1, 1, 1, 1, 1, 1, 1],
	//[1, 1, 1, 1, 1, 1, 1],
	//[1, 1, 1, 1, 1, 1, 1],
	//[1, 1, 1, 1, 1, 0, 0],
	//[1, 1, 1, 1, 1, 0, 0],
	//]

	//findRectangle(image3) =>
	//x: 5, y: 3, width: 2, height: 2
	//3,5 4,6

	//image4 = [
	//[0, 1, 1, 1, 1, 1, 1],
	//[1, 1, 1, 1, 1, 1, 1],
	//[1, 1, 1, 1, 1, 1, 1],
	//[1, 1, 1, 1, 1, 1, 1],
	//[1, 1, 1, 1, 1, 1, 1],
	//]

	//findRectangle(image4) =>
	//x: 0, y: 0, width: 1, height: 1
	//0,0 0,0

	//image5 = [
	//[0],
	//]

	//findRectangle(image5) =>
	//x: 0, y: 0, width: 1, height: 1
	//0,0 0,0


	public static void main(String[] args) {
	 int[][] image1 = {
	   {1, 1, 1, 1, 1, 1, 1},
	   {1, 1, 1, 1, 1, 1, 1},
	   {1, 1, 1, 0, 0, 0, 1},
	   {1, 1, 1, 0, 0, 0, 1},
	   {1, 1, 1, 1, 1, 1, 1}
	 };
	 
	 System.out.println(Arrays.toString(returnCordinateOfZero(image1)));

	 int[][] image2 = {
	   {1, 1, 1, 1, 1, 1, 1},
	   {1, 1, 1, 1, 1, 1, 1},
	   {1, 1, 1, 1, 1, 1, 1},
	   {1, 1, 1, 1, 1, 1, 1},
	   {1, 1, 1, 1, 1, 1, 0}
	 };

	 int[][] image3 = {
	   {1, 1, 1, 1, 1, 1, 1},
	   {1, 1, 1, 1, 1, 1, 1},
	   {1, 1, 1, 1, 1, 1, 1},
	   {1, 1, 1, 1, 1, 0, 0},
	   {1, 1, 1, 1, 1, 0, 0}
	 };

	 int[][] image4 = {
	   {0, 1, 1, 1, 1, 1, 1},
	   {1, 1, 1, 1, 1, 1, 1},
	   {1, 1, 1, 1, 1, 1, 1},
	   {1, 1, 1, 1, 1, 1, 1},
	   {1, 1, 1, 1, 1, 1, 1}
	 };

	 int[][] image5 = {
	   {0}
	 };

	}

	public static int[] returnCordinateOfZero(int[][] image){
	 int topr = 0;
	 int leftc = 0;
	 int w = 0;
	 int h = 0;
	 int c = 0;
	 
	 for (int r=0; r < image.length; r++){
	   if (image[r][c] == 0){
	     topr = r;
	     leftc = c;
	     
	     
	     for(c = r; c < image.length-1; c++){
	       if (image[r][c] ==0){
	         w++;
	     }else{
	         h++;
	         break;
	       }
	   }
	   c++;
	 }   
	}
	 int[] res = {topr, leftc, w, h};
	 return res;
	}
	}

