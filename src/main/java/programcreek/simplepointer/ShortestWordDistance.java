package programcreek.arraystring.simplepointer;

//import org.apache.poi.util.SystemOutLogger;

public class ShortestWordDistance {
/*Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		System.out.println(shortestDistance(words, "coding", "practice"));

	}
	public static int shortestDistance(String[] words, String word1, String word2) {
		   int m=-1;
		   int n=-1;
		 
		   int min = Integer.MAX_VALUE;
		 
		   for(int i=0; i<words.length; i++){
		        String s = words[i];
		        if(word1.equals(s)){
		            m = i;
		            if(n!=-1)
		                min = Math.min(min, m-n);
		        }else if(word2.equals(s)){
		            n = i;
		            if(m!=-1)
		                min = Math.min(min, n-m);
		        }
		   }
		 
		   return min;
		}

}
