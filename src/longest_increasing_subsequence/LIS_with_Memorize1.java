package longest_increasing_subsequence;

public class LIS_with_Memorize1 {

	static int lis_with_Memorize1(int[] arr, int size) {
		if(size == 1) {
			return 1;
		}
		
		int max = 1;
		int max_lis_index = 0; //store the index of current number with max LIS
		
		int[] lis = new int[size];
		for(int i = 0; i < size; i++) {
			lis[i] = 1;
		}
		
		boolean isUpdate_max_lis_index = true;
		
		for(int i = 1; i < size; i++) {
			if(isUpdate_max_lis_index) {
				if(arr[i] > arr[max_lis_index]) {
					max++;
					max_lis_index = i;
					lis[i] = max;
				}else {
					isUpdate_max_lis_index = false; 
					//is no update max_lis_index, that means we have multiple choice, next loop we need check many
				}
			}
			else { //no update last time, check lis[] from max_lis_index to i-1
				for(int j = max_lis_index; j < i; j++) {
					if(arr[i] > arr[j]) {
						//update lis
						if(lis[j] + 1 > lis[i]) {
							lis[i] = lis[j]+1;
						}
					}
				}
				if(lis[i] > max) {
					max = lis[i];
					max_lis_index = i;
					isUpdate_max_lis_index = true;
				}
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60, 75, 73};
		int arr1[] = {3,1,5,2,6,4,9};
		int arr2[] = {10, 1, 2, 3, 4, 5};// this example prove this algorithm is not correct
	    int n = arr.length;
	    int m = arr1.length;
	    int k = arr2.length;
	    System.out.println("Length of lis is "
                + lis_with_Memorize1(arr2, k));

	}

}
