package programcreek.arraystring.hashmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
	
	/*249. Group Shifted Strings Medium
Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

Example:

Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
Output: 
[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		
		List<List<String>> list = groupStrings(strings);
		System.out.println(list);
	}
	
	public static List<List<String>> groupStrings(String[] strings) {
	    List<List<String>> result = new ArrayList<List<String>>();
	    HashMap<String, ArrayList<String>> map 
	                    = new HashMap<String, ArrayList<String>>();
	 
	    for(String s: strings){
	        char[] arr = s.toCharArray();
	        if(arr.length>0){
	            int diff = arr[0]-'a';
	            for(int i=0; i<arr.length; i++){
	                if(arr[i]-diff<'a'){
	                   arr[i] = (char) (arr[i]-diff+26);
	                }else{
	                   arr[i] = (char) (arr[i]-diff); 
	                }
	 
	            }
	        }  
	 
	        String ns = new String(arr);
	        if(map.containsKey(ns)){
	            map.get(ns).add(s);
	        }else{
	            ArrayList<String> al = new ArrayList<String>();
	            al.add(s);
	            map.put(ns, al);
	        }
	    }
	 
	    for(Map.Entry<String, ArrayList<String>> entry: map.entrySet()){
	        Collections.sort(entry.getValue());
	    }
	 
	    result.addAll(map.values());
	 
	    return result;
	}

}
