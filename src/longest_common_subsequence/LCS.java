package longest_common_subsequence;

public class LCS {

	static int lcs(char[] arr1, int size1, char[] arr2, int size2) {
		
		if(size1 == 0 || size2 == 0) {
			return 0;
		}
		
		//4. size1 != 1, size2 != 1
		if(arr1[size1-1] == arr2[size2-1]) {
			return 1 + lcs(arr1, size1-1, arr2, size2-1);
		}else {
			return Math.max(lcs(arr1, size1, arr2, size2-1), lcs(arr1, size1-1, arr2, size2));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "AGGTAB";
	    String s2 = "GXTXAYB";
	 
	    char[] X=s1.toCharArray();
	    char[] Y=s2.toCharArray();
	    int m = X.length;
	    int n = Y.length;
	 
	    System.out.println("Length of LCS is" + " " +
	                                  lcs( X, m, Y, n ) );
	}

}
