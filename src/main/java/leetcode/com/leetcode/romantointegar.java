package leetcode.com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class romantointegar {
	/*
	 * Given a roman numeral, convert it to an integer.
	   Input is guaranteed to be within the range from 1 to 3999.
	   Roman numeral (n)	Decimal value (v)
						I	1
						IV	4
						V	5
						IX	9
						X	10
						XL	40
						L	50
						XC	90
						C	100
						CD	400
						D	500
						CM	900
						M	1000

	 */

	public static void main(String[] args) {
		
		System.out.println(romanToInt("DCXXI"));

	}
public static int romanToInt(String s) {
	int intResult = 0;
	Map<String, Integer> roman2IntMap2 = new HashMap<String, Integer>();
	Map<String, Integer> roman2IntMap = new HashMap<String, Integer>();
	roman2IntMap.put("I", 1);
	roman2IntMap2.put("IV", 4);
	roman2IntMap.put("V", 5);
	roman2IntMap2.put("IX", 9);
	roman2IntMap.put("X", 10);
	roman2IntMap2.put("XL", 40);
	roman2IntMap.put("L", 50);
	roman2IntMap2.put("XC", 90);
	roman2IntMap.put("C", 100);
	roman2IntMap2.put("CD", 400);
	roman2IntMap.put("D", 500);
	roman2IntMap2.put("CM", 900);
	roman2IntMap.put("M", 1000);
	for(int i=0; i < s.length(); i++){
		boolean flag = true;
		String pointer2 = "";
		String pointer1 = "";
		if(i < s.length()-1){
			pointer2 = s.substring(i, i+2);
			for(String key2 : roman2IntMap2.keySet()){
				if(pointer2.equals(key2)){
					intResult += roman2IntMap2.get(key2);
					i++;
					flag = false;
					break;
				}
			}
		}			
		if(flag){			
			pointer1 = s.substring(i, i+1);
			for(String key1 : roman2IntMap.keySet()){
				if(pointer1.equals(key1)){
					intResult += roman2IntMap.get(key1);
					break;
					}
				}
		}
		
	}
	return intResult;   
    }
}
