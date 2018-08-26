package longest_increasing_subsequence;

public class LIS_NlogN {

	static int lis_nlogn(int[] arr) {
		int length = arr.length;
		int[] lis = new int[length];
		int last_index = 0;
		//two cases:
		//1. if new element is larger than the last element in lis, just add
		//2. if new element is smaller than the last element in lis, replace the one larger than this new element
		//for case 2, we need binarySearch to find the place to replace.
		lis[0] = arr[0];
		
		for(int i = 1; i < length; i++) {
			if(arr[i] < lis[last_index]) { //replece
				lis[binarySearch(lis, 0, last_index, arr[i])] = arr[i];
			}else if(arr[i] > lis[last_index]) {
				last_index++;
				lis[last_index] = arr[i];
			}
		}
		
		return last_index+1;
		
		
	}
	
	static int binarySearch(int[] arr, int left, int right, int val) {
		int mid;
		while(left <= right) {
			mid = arr[(left + right)/2];
			if(val == mid) {
				return (left + right)/2;
			}else if(val > mid) {
				left ++;
			}else {
				right --;
			}
		}
		return left;
	}
	
	
	
	public static void main(String[] args) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60, 75, 73};
		int arr1[] = {3, 1, 5, 2, 6, 4, 9};
		int arr2[] = {10, 1, 2, 3, 4, 5};// this example prove this algorithm is not correct
	    int n = arr.length;
	    int m = arr1.length;
	    int k = arr2.length;
	    System.out.println("Length of lis is "
                + lis_nlogn(arr1));

	}
}
