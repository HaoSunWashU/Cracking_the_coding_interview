package find_num_of_sets_in_array_with_fixed_sum;

import java.util.HashMap;
/* [2, 4, 6 ,10] find num of sets in this array with the sum 16
 * the result is 2, [2, 4, 6] and [6, 10]
 * */

public class NumOfSums {

	static int numOfSets_main(int[] array, int sum) {
		HashMap<String, Integer> mem = new HashMap<String, Integer>();
		return numOfSets_recur(array, sum, array.length-1, mem);
	}
	
	private static int numOfSets_recur(int[] array, int sum, int index, HashMap<String, Integer> mem) {
		String key = sum + ":" + index;
		if(mem.containsKey(key)) {
			return mem.get(key);
		}
		
	} 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
