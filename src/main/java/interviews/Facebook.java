package interviews;

public class Facebook {
	
//	#find the longest common suffix in strings
//	#Example 1:
//	#  Input:  ["ABCDEF", "BEF", "DAEF"]
//	#  Output:  "EF"
//	  
//	#Example 2:
//	#  Input: ["GDEFG", "DEFG", "ABCEFG"]
//	#  Output:  "EFG"
//	  

	  public static void main(String[] args) {
		  String[] strs = {"ABCDEF", "BEF", "DAEF"};
		  
		  String result = longestCommonPrefix( strs );
//		  String result = longComSuffix( strs );
		  System.out.println(result);
	  }
	  public static String longComSuffix(String[] strs ){
	    
	  if (strs == null || strs.length == 0)  
	    return "";
	  String suffix = strs[0];
	  
	  for (int j = 0; j < strs.length -1 ; j++){
	    if(strs[j].length() < strs[j+1].length())
	      suffix =  strs[strs[j].length()];
	  }
	  
	  
	  for(int i = strs.length-1; i > 0; i--){ // i = 2
	    while(strs[i].indexOf(suffix) != 0){ 
	      suffix = suffix.substring(0, suffix.length()-1);
	    
	      if (suffix.isEmpty()) return "";
	    }
	  }
	    
	  return suffix;  
	  
	  }
	  
	  public static String longestCommonPrefix(String[] strs) {
		    if (strs.length == 0) return "";
		    String prefix = strs[0];
		    for (int i = 1; i < strs.length; i++)
		        while (strs[i].indexOf(prefix) != 0) {
		            prefix = prefix.substring(0, prefix.length() - 1);
		            if (prefix.isEmpty()) return "";
		        }        
		    return prefix;
		}

}
