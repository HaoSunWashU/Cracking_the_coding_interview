package count_distinct_subsequences;

import java.util.HashMap;

public class Count_Distinct_Subsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countSub("aaa"));
	}
	
	public static int countSub(String str) {
		int length = str.length();
		//char_index store the char and its last appeared index
		HashMap<Character, Integer> char_index = new HashMap<Character, Integer>();
		int[] count_sub = new int[length+1]; //store the count of subsequences in different length
		count_sub[0] = 1; //Length 0 only has one subsequence, "".
		
		//iterate all the chars in the string
		for(int i = 1; i <= length; i++) { //i begins at 1, in order to indicate the length.
			count_sub[i] = 2 * count_sub[i-1];
			char currentChar = str.charAt(i-1);
			if(char_index.containsKey(currentChar)) { //if appear before, deduct repetition
				int index = char_index.get(currentChar);
				count_sub[i] -= count_sub[index-1]; // count_sub[lastIndex+1] is the repetition
			}
			char_index.put(currentChar, i);
		}
		
		return count_sub[length]; 
	}

}
