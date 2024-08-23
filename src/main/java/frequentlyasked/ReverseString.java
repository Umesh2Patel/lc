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

		String output3 = reverseWordsWithStringBuilder(input);
		System.out.println("reverseWordsWithStringBuilder output: " + output3);

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

	public static String reverseWordsWithStringBuilder(String sentence) {
		// Split the sentence into words using space as a delimiter
		String[] words = sentence.split(" ");

		// Use StringBuilder to build the reversed sentence
		StringBuilder reversed = new StringBuilder();

		// Loop through the words array in reverse order
		for (int i = words.length - 1; i >= 0; i--) {
			reversed.append(words[i]);
			if (i != 0) {
				reversed.append(" ");
			}
		}

		return reversed.toString();
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
