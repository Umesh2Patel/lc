package programcreek.simplepointer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels {
	/**/

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static List<Integer> partitionLabels(String S) {
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    
	    HashMap<Character, int[]> map = new HashMap<Character, int[]>();
	    for(int i=0; i<S.length(); i++){
	        char c = S.charAt(i);
	        int[] arr = map.get(c);
	 
	        if(arr == null){
	            arr = new int[]{i, i};
	            map.put(c, arr);
	        }else{
	            arr[1]=i;
	        }
	    }
	 
	    ArrayList<int[]> list = new ArrayList<int[]>();
	    list.addAll(map.values());
	 
	    Collections.sort(list, Comparator.comparing((int[] arr) -> arr[0]));
	 
	    int[] t = list.get(0);
	    for(int i=1; i<list.size(); i++){
	        int[] range = list.get(i);
	 
	        if(range[1]<=t[1]){
	            continue;
	        }else if(range[0]>t[1]){ //impossible be equal
	            result.add(t[1]-t[0]+1);     
	            t = range;
	        }else{
	            t[1] = range[1];
	        }
	    }
	 
	    result.add(t[1]-t[0]+1);
	 
	    return result;
	}
}
