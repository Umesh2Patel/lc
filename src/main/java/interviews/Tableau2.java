package interviews;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tableau2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> a = new ArrayList<Integer>();
		List<Integer> b = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(0);
		b.add(2);
		b.add(3);
		List<Integer> c = mergeArrays(a,b);
		System.out.println(c);
	}

	private static List<Integer> mergeArrays(List<Integer> a, List<Integer> b) {
		// TODO Auto-generated method stub
		a.addAll(b);
		Collections.sort(a);
		for(int i=0; i<a.size();i++ )
        {
            System.out.println(a.get(i));
        }
		for (int i = 1; i < b.size(); i++){
	        int ele = b.get(i);
	        int j = a.size();
	        while(j >= 0 && a.get(j) > ele){
	            a.add(j+1, a.get(j));
	            j--;
	        }
	        if(a.get(j) == b.get(i)){
	            a.add(j+1, b.get(i));
	        }
	        a.add(j+1, ele);
	    }
	    
	    return a;
	}

}
