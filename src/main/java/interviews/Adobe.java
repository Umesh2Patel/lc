package interviews;

public class Adobe {
	/*Palindromes are strings that read the same from the left or right, for example madam or 0110. You will be given a string representation of a number and a maximum number of changes you can make. Alter the string, one digit at a time, to create the string representation of the largest number possible given the limit to the number of changes. The length of the string may not be altered, so you must consider 's left of all higher digits in your tests. For example is valid, is not. Given a string representing the starting number and a maximum number of changes allowed, create the largest palindromic string of digits possible or the string -1 if it's impossible to create a palindrome under the contstraints. Function Description Complete the highestValuePalindrome function in the editor below. It should return a string representing the largest value palindrome achievable, or -1. highestValuePalindrome has the following parameter(s): s: a string representation of an integer n: an integer that represents the length of the integer string k: an integer that represents the maximum number of changes allowed Input Format The first line contains two space-separated integers, and , the number of digits in the number and the maximum number of changes allowed. The second line contains an -digit string of numbers.
	TruongSon Nguyen3:22 PM
	Output Format Print a single line with the largest number that can be made by changing no more than digits. If this is not possible, print -1. Sample Input 0 4 1 3943 Sample Output 0 3993 Sample Input 1 6 3 092282 Sample Output 1 992299 Sample Input 2 4 1 0011 Sample Output 2 -1 Explanation Sample 0 There are two ways to make a palindrome by changing no more than digits:*/
//		truonguy@adobe.com
	public static void main(String[] args) {
		// Test Cases:
        System.out.println(maxPalindromeUsingKChanges("43435", 3, 4)); // Output --> 93939
        System.out.println(maxPalindromeUsingKChanges("0", 1, 1)); // Output --> 9
        System.out.println(maxPalindromeUsingKChanges("3943", 1, 4)); // Output --> 3993
        System.out.println(maxPalindromeUsingKChanges("092282", 3, 6)); // Output --> 992299
        System.out.println(maxPalindromeUsingKChanges("0011", 1, 4)); // Output --> -1 
        System.out.println(maxPalindromeUsingKChanges("1", 1, 1)); // Output --> 9
        System.out.println(maxPalindromeUsingKChanges("3943", -1, 4)); // Output --> -1 as Invalid case
        System.out.println(maxPalindromeUsingKChanges("3943343434", 20, 4)); // Output --> 9999999999
        System.out.println(maxPalindromeUsingKChanges("222", 0, 3)); // Output --> 222
        System.out.println(maxPalindromeUsingKChanges("12345", 1, 5)); // Output --> -1
	}
	
	public static String maxPalindromeUsingKChanges(String str, int k, int n) { 
        char palindrome[] = str.toCharArray(); 
        String res = ""; 
        // Iinitialize l and r by leftmost and  
        // rightmost ends  
        int l = 0; 
        int r = str.length() - 1; 
  
        // first try to make String palindrome  
        while (l < r) { 
            // Replace left and right character by  
            // maximum of both  
            if (str.charAt(l) != str.charAt(r)) { 
                palindrome[l] = palindrome[r] = (char) Math.max(str.charAt(l), 
                                          str.charAt(r)); 
                k--; 
            } 
            l++; 
            r--; 
        } 
  
        // If k is negative then we can't make String palindrome  
        if (k < 0) { 
            return "-1"; //Invalid case
        } 
  
        l = 0; 
        r = str.length() - 1; 
  
        while (l <= r) { 
            // At mid character, if K>0 then change  
            // it to 9  
            if (l == r) { 
                if (k > 0) { 
                    palindrome[l] = '9'; 
                } 
            } 
  
            // If character at lth (same as rth) is  
            // less than 9  
            if (palindrome[l] < '9') { 
                /* If none of them is changed in the  
            previous loop then subtract 2 from K  
            and convert both to 9 */
                if (k >= 2 && palindrome[l] == str.charAt(l) 
                        && palindrome[r] == str.charAt(r)) { 
                    k -= 2; 
                    palindrome[l] = palindrome[r] = '9'; 
                } /* If one of them is changed in the previous  
                loop then subtract 1 from K (1 more is  
                subtracted already) and make them 9 */ 
               else if (k >= 1 && (palindrome[l] != str.charAt(l) 
                        || palindrome[r] != str.charAt(r))) { 
                    k--; 
                    palindrome[l] = palindrome[r] = '9'; 
                } 
            } 
            l++; 
            r--; 
        } 
        for(int i = 0;i<palindrome.length;i++) 
            res+=palindrome[i]; 
        return res; 
    } 

}

/*
 Pseudo Code-
This program calculates and returns the largest palindrome by changing at most k digits.
function maxPalindromeusingKChanges(Argument length, Argument k, Argument string){
    Convert the string to character as Array
    Create and Initialize l and r by leftmost and rightmost ends
    
    First make string palindrome by replacing left and right character by maximum of both
    
    If k is negative then we can't make string palindrome, returns "-1" for Invalid case
    
    Calculate the maximum palindrome:
        At starting character, if K>0 then change it to 9 
    
        If character at lth (same as rth) is less than 9
    
        If none of them is changed in the previous loop then subtract 2 from K and convert both to 9 
    
        If one of them is changed in the previous loop then subtract 1 from K (1 more is subtracted already) and make them 9 
    
    convert back the character array to string
    
    return the maximum palindrome
} 
 **/
