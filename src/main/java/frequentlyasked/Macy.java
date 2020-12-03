package frequentlyasked;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Macy {
	public static void main(String[] args) throws Exception {

		String input = "aaaabbbcccdddee";
		System.out.println(input);
		String output = countChar(input);
		System.out.println(output);
	}

	public static String countChar(String input) {
     String output = "";
     HashMap<Character, Integer> m = new HashMap<Character, Integer>();
     int count = 1;
     
     for(int i =0; i< input.length()-1; i++){
         
         if(input.charAt(i) == input.charAt(i+1)){
            m.put(input.charAt(i), count++); 
         }
         
         else{
             m.put(input.charAt(i), count);
             count =1;
         } 
             
     }
     
     for(Entry<Character, Integer> m1 : m.entrySet()){
          output =  output + m1.getKey() + m1.getValue();
     }
     
     return output;
	 
//	 HashMap<Character, Integer> m = new HashMap<Character, Integer>();
	    
     
	    
//		for(Char c :arra ){
//
//	if(m.containsKey(c)){
//	m.put(c, m.get(c)+1);
//
//	}
//	else {
//	m.put(c,1);
//	}
//
//	}
//
//	String str = "";
//	String s="";
//	for(Map.Entry<Character , Integer> map : m.entrySet()){
//
//	map.getKey();
//	map.getValue();
//	s=map.getKey().toString()+map.getValue().toString();
//	str+=s;
//	}
//	return str; 
 }

}

/*
 * Input aaaabbbcccdddee output a4b3c3d3e3
 */