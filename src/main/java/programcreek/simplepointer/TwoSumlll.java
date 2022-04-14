package programcreek.simplepointer;

import java.util.HashMap;

public class TwoSumlll {
	/*Two Sum III – Data structure design (Java)
	 * Design and implement a TwoSum class. It should support the following operations: add and find.

	add - Add the number to an internal data structure.
	find - Find if there exists any pair of numbers which sum is equal to the value.
	 * */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		TwoSum3 ts = new TwoSum3();
		ts.add(1);
		ts.add(3);
		ts.add(5);
		boolean r1 = ts.find(4);
		boolean r2 = ts.find(7);
//		int[] indices = twoSum(nums, target);
		System.out.println(r1);
		System.out.println(r2);
	}

}

class TwoSum3 {
	private HashMap<Integer, Integer> elements = new HashMap<Integer, Integer>();
 
	public void add(int number) {
		if (elements.containsKey(number)) {
			elements.put(number, elements.get(number) + 1);
		} else {
			elements.put(number, 1);
		}
	}
 
	public boolean find(int value) {
		for (Integer i : elements.keySet()) {
			int target = value - i;
			if (elements.containsKey(target)) {
				if (i == target && elements.get(target) < 2) {
					continue;
				}
				return true;
			}
		}
		return false;
	}
}