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
		
		//### 1. Check the memory first to see if there are resutls ###//
		String key = sum + ":" + index;
		if(mem.containsKey(key)) {
			return mem.get(key);
		}
		
		//### 2. Base Case ###//
		if(sum == 0) {		//if sum == 0, there are only one option: { } emptyh list
			return 1;
		}else if(sum < 0) {
			return 0;
		}else if(index < 0) {
			return 0;
		}
		
		//### 3. Recursive process ###
		//two options, include array[index] and exclude array[index]
		int res = numOfSets_recur(array, sum - array[index], index - 1, mem) + 
				numOfSets_recur(array, sum, index - 1, mem);
		mem.put(key, res);
		return res;
	} 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {2, 4, 6, 10};
		System.out.println(numOfSets_main(array, 16));
	}

}
