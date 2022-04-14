package binarysearch;

public class Anagram {

    /*
    Given two strings s and t, return true if t is an anagram of s, and false otherwise.



Example 1:

Input: s = "aarmy", t = "amary"
Output: true


Example 2:

Input: s = "rat", t = "car"
Output: false
     */

    public static void main(String[] arg){
//        System.out.println(areAnagram("aarmy".toCharArray(), "amary".toCharArray()));
//        System.out.println(areAnagram("rat".toCharArray(), "car".toCharArray()));
//        System.out.println(areAnagram("".toCharArray(), "car".toCharArray()));
//        System.out.println(areAnagram("".toCharArray(), "".toCharArray()));
//        System.out.println(areAnagram("abc".toCharArray(), "a".toCharArray()));
        System.out.println(areAnagram("(12)".toCharArray(), "4321".toCharArray()));
//        System.out.println(areAnagram(null, "4321".toCharArray()));

    }


    public static boolean areAnagram(char[] str1, char[] str2){
        int[] count = new int[265];
        if (str1.length != str2.length)
            return false;

        for (int i=0; i< str1.length; i++){
            count[str1[i] - '0']++;
            count[str2[i] - '0']--;
        }

        for(int i = 0; i < 256; i++){
            if(count[i] != 0){
                return false;
            }
        }

        return true;
    }

}
