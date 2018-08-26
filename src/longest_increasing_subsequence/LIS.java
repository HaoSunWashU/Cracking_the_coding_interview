package longest_increasing_subsequence;

/*
 * used to calculate the longest increasing subsequence
 * Dynamic Programming, this is optimal substructure:
 * use current number compare with former subarray's number with max lis 
*/
public class LIS {

	static int max_lis; //used to save the current max lis
	
	//use recursive and memorize the former max lis
	static int _lis(int[] arr, int size) {
		//base case
		if(size == 1) {
			return 1;
		}
		
		//### calculate the rest subarray ###//
		//initialize
		int temp_result;  			//used for compare
		int current_max_lis = 1;	
		
		//use the last one to compare with number at index 0 to n-2
		for(int i = 0; i < size-1; i++) {
			//get the former subarray's lis
			temp_result = _lis(arr, i+1); //i+1 is the size
			
			//compare the lis and update. if last element > current number, so lis is temp_result + 1
			if(arr[size-1] > arr[i] && temp_result + 1 > current_max_lis) {
				current_max_lis = temp_result + 1;
			}
		}
		
		return current_max_lis;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
	    int n = arr.length;
	    System.out.println("Length of lis is "
	                           + _lis(arr, n));
	}

}
