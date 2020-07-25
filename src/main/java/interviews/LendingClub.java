package interviews;

public class LendingClub {
	
	/*uestion:

Given a list of birth year and death year of people, Return a list which has number of people alive in each year for all the possible years in collection

Each item is tuple with birth and death year of a person

# Input: Each item is a tuple with birth and death year of a person
# 
# Input:

5
1945, 2001
1930, 1956
1956, 2017
1945, 1995
1948, 1953

[ 0 0 0 0 0 ... 0 ]

1930            2017

[0,0 ......1,   1, ......  1,.... 000]
 1930     1945 1946      2001       2017]
 
 [1, 1.... 1,    2
  1930,... 1944, 1945... 1956...
  
[ 0 0 1 .....  -1 0 0 ]


N .. K .. O (N * K)



# 
# Output 
# 
# {
# 
# 1930: 1, // Number of people alive in that year
# 1931: 1,
# ......
# 1945: 3,
# ....
# 1954: 2,
# 
# 1956: 2,
# .....
# 2000: 2,
# ......
# 2017: 1
#
# }
*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] b= {1945, 1930, 1956, 1945, 1948};
		int[] b1= {3, 5};
		int[] d= {2001, 1956, 2017, 1995, 1953};
		int[] d1= {6, 9};
		sol(b,d);
//		sol(b1,d1);

	}
	
	public static void sol(int[] b, int[] d) {
		
		int minYear = b[0];
	     int maxYear = d[0];
	      
	      for (int i = 1; i < b.length; i++){
	        if (b[i] < minYear){
	          minYear = b[i];
	        }
	      }
	      
	       for (int i = 1; i < d.length; i++){
	        if (d[i] > maxYear){
	          maxYear = d[i];
	        }
	      }
		int[] r = new int[maxYear - minYear +1];
		
		for(int i : b)
			r[i - minYear] +=  1;
		
		for(int i : d)
			if((i - minYear +1)  < r.length)
				r[i - minYear + 1] +=  -1;
		
		for(int i= 0; i < r.length-1; i++) {
			r[i+1] += r[i] ;
		}
		
		for(int i = 0; i < r.length; i++) {
			System.out.println(i+minYear + " : " + r[i]);
		}

		
	}

}
