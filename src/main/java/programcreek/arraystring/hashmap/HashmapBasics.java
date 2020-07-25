package programcreek.arraystring.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator; 

public class HashmapBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		System.out.println("Initial list of elements: " + hm);
		hm.put(100, "Amit");
		hm.put(101, "Vijay");
		hm.put(102, "Rahul");

		System.out.println("After invoking put() method ");
		for (Map.Entry m : hm.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}

		// hm.putIfAbsent(103, "Gaurav");
		System.out.println("After invoking putIfAbsent() method ");
		for (Map.Entry m : hm.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(104, "Ravi");
		map.putAll(hm);

		System.out.println("After invoking putAll() method ");
		for (Map.Entry m : map.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
		
		
		System.out.println("Iterating keys");
		for (int i : map.keySet()) {
			System.out.println(i);
		}
		
		
		System.out.println("Iterating values");
		for (String i : map.values()) {
			System.out.println(i);
		}
		
		
		 //key-based removal  
	    map.remove(100);  
	    System.out.println("Updated list of elements: "+map);  
	    //value-based removal  
	    map.remove(101);  
	    System.out.println("Updated list of elements: "+map);  
	    //key-value pair based removal  
//	    map.remove(102, "Rahul");  
//	    System.out.println("Updated list of elements: "+map);  
	    
	    Map<String,String> gfg = new HashMap<String,String>(); 
	      
        // enter name/url pair 
        gfg.put("GFG", "geeksforgeeks.org"); 
        gfg.put("Practice", "practice.geeksforgeeks.org"); 
        gfg.put("Code", "code.geeksforgeeks.org"); 
        gfg.put("Quiz", "quiz.geeksforgeeks.org"); 
          
        // using iterators 
        Iterator<Map.Entry<String, String>> itr = gfg.entrySet().iterator(); 
          
        while(itr.hasNext()) 
        { 
             Map.Entry<String, String> entry = itr.next(); 
             System.out.println("Key = " + entry.getKey() +  
                                 ", Value = " + entry.getValue()); 
        } 
		
        
     // forEach(action) method to iterate map Only for Java 8
//        gfg.forEach((k,v) -> System.out.println("Key = " + k + ", Value = " + v)); 
		
	}

}
