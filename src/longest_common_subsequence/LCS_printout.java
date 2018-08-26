package longest_common_subsequence;

//if we want to print out the longest_common_subsequence of two strings,
//we need a two-dimension array to record the lcs value
public class LCS_printout {

	static void lcs_printout(char[] arr1, char[] arr2) {
		int len1 = arr1.length;
		int len2 = arr2.length;
		int[][] lcs = new int[len2+1][len1+1];  
		//lcs[i][j] represent the lcs between subarray1 from arr1[0] to arr[j-1] and subarray2 from arr2[0] to arr2[i-1] 
		
		//calculate all the lcs possibility
		for(int i = 1; i < len2 + 1; i ++) {
			for(int j = 1; j < len1 + 1; j++) {
				if(arr1[j-1] == arr2[i-1]) {
					lcs[i][j] = lcs[i-1][j-1]+1;
				}else {
					lcs[i][j] = lcs[i][j-1] > lcs[i-1][j]? lcs[i][j-1] : lcs[i-1][j];
				}
			}
		}
		
		char[] res = new char[lcs[len2][len1]];
		
		//print out the longest common subsequence
		//check from the last one of lcs, compare with its two neighbors
		int i = len2;
		int j = len1;
		int count = res.length;
		while(lcs[i][j] > 0) {
			if(lcs[i][j] > lcs[i-1][j] && lcs[i][j] > lcs[i][j-1]) { //this position has one char should be print
				res[count-1] = arr1[j-1];
				count--;
				i--;
				j--;
			}else if(lcs[i][j] == lcs[i-1][j]) {
				i--;
			}else if(lcs[i][j] == lcs[i][j-1]) {
				j--;
			}
		}
		
		for(int k = 0; k < res.length; k ++) {
			System.out.print(res[k]);
		}
	}
	
	public static void main(String[] args) {
		String s1 = "AGGTAB";
	    String s2 = "GXTXAYB";
		lcs_printout(s1.toCharArray(), s2.toCharArray());
	}

}
