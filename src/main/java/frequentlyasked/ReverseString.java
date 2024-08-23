package frequentlyasked;

import java.util.Arrays;

public class ReverseString {

	public static void main(String[] args) {
		// How to print string = "Hello Java Program" as string ="olleH avaJ
		// margorP"?

		String input = "Hello Java Program";


		String output = reverseChar(input);
		System.out.println("reverseChar using str.toCharArray() output: "+ output);

		String output2 = reverseString(input);
		System.out.println("reverseString using reverse().toString() and StringBuilder  output: "+ output2);
		
		String output1 = reverseWord(input);
		System.out.println("reverseWord output: " + output1);

	}

	private static String reverseWord(String input) {
		// TODO Auto-generated method stub
		String reverseString = "";
		
		String[] words = input.split(" ");
		System.out.println("words array: " + Arrays.toString(words));
		
//		for (int i = 0; i < words.length; i++)
		for (String word : words)
		{
			//Taking each word and reversing it
//			String word = words[i];
			String reverseWord = "";
			
			
			for(int j = word.length()-1; j >= 0; j--)
			{
				reverseWord = reverseWord + word.charAt(j);
			}
			
			reverseString = reverseString + reverseWord + " ";
		}
		
		return reverseString;
	}

	private static String reverseChar(String str) {
		// TODO Auto-generated method stub
		String result = "";

		char[] ca = str.toCharArray();
		System.out.println(ca);

		for (char c : ca) {
			result = c + result;
		}
		return result;
	}

	public static String reverseString(String str) {
		StringBuilder sb = new StringBuilder(str);
		return sb.reverse().toString();
	}

}
