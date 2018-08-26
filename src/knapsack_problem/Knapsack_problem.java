package knapsack_problem;

public class Knapsack_problem {

	//### how knapsack problem works ###//
	/* 1. Recursive
	 * 	 C: Rest capacity; V[i]: Value; W[i]: Weight
	 * 
	 * 	ks(i, C) represents the largest value of i things that can be put into the knapsack with 
	 * 	capacity C 
	 * 
	 * 	Base case: if(i == 0 or C == 0) return 0;
	 * 
	 * 	if(W[i] > C) { // means i-th thing can not put into the knapsack
	 * 		return ks(i-1, C);
	 * 	}else{
	 * 		int temp1 = ks(i-1, C);
	 * 		int temp2 = V[i] + ks(i-1, C-W[i]);
	 * 		return max(temp1, temp2);
	 * 	}
	 * 
	 * 2. Recursive with memo 
	 * 
	 * 	Because the recursive function has two parameters, so we need a two-dimensional array
	 * 	ks_value[i][j] represents the result of ks(i, j);
	 * 
	 * 	int[][] ks_value = new int[n+1][C+1]; // have ks_value[n][C], n-th thing
	 * 	
	 * 
	 * 3. Bottom-up
	 * 	
	 * */
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
