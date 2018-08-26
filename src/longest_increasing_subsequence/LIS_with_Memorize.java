package longest_increasing_subsequence;

public class LIS_with_Memorize {

	static int[] lis;
	static int _lis_with_Memorize(int[] arr, int size) {
		if(size == 1) {
			return 1;
		}
		
		//iterate all the former number and its relative lis
		int temp_result;
		int current_lis = 1;
		
		//In fact, take the last element 
		for(int i = 0; i < size-1; i++) {
			if(lis[i] != -1) {
				temp_result = lis[i];
			}else {
				temp_result = _lis_with_Memorize(arr, i+1);
			}
			
			if(arr[size-1] > arr[i] && temp_result + 1 > current_lis) {
				current_lis = temp_result + 1;
			}
			
			if(temp_result > current_lis) {
				current_lis = temp_result;
			}
		}
		return current_lis;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60};
		int arr1[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
	    int n = arr.length;
	    int m = arr1.length;
	    lis = new int[m];
	    lis[0] = 1;
	    for(int i = 1; i < m; i++) {
	    	lis[i] = -1;
	    }
	    System.out.println("Length of lis is "
                + _lis_with_Memorize(arr1, m));
	}
}
