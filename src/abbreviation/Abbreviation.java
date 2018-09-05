package abbreviation;

/*
 * You can perform the following operations on the string, a:

Capitalize zero or more of a's lowercase letters.
Delete all of the remaining lowercase letters in a.
Given two strings,  a and b, determine if it's possible to make a equal to b as described. If so, print YES on a new line. Otherwise, print NO.

For example, given AbcDE and ABDE, in AbcDE we can convert b and delete c to match. If AbcDE and AFDE, matching is not possible because letters may only be capitalized or discarded, not changed.

 * 
 * */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Abbreviation {

	// Complete the abbreviation function below.
    static String abbreviation(String a, String b) {
        int[][] mem1 = new int[a.length()][b.length()]; //default == 0;
        
        if(match_back(a, b, a.length()-1, b.length()-1, mem1) == 2){
            return "YES";
        }else{
            return "NO";
        }

    }
    
    //index1 and index2 indicate the comparison pos, mem is the memory for resutls
    //in mem, 1 is false, 2 is true, 0 is default
    static int match_back(String a, String b, int index1, int index2, int[][] mem){
        
        //### Base case
        if(index1 < 0 && index2 >= 0){
            return 1;
        }
        
        if(index2 < 0){ //index2 moves only when there is match, if index2 < 0 means all match
            int isMatch = 2;
            for(int i = 0; i <= index1; i ++) {
            	if(a.charAt(i) < 97) {
            		return 1;
            	}
            }
        	return isMatch;
        }
        
        if(mem[index1][index2] != 0){
            return mem[index1][index2];
        }
        
        //### Recur
        if(a.charAt(index1) == b.charAt(index2)){
            //# Case 1: Match or Upper case match
            mem[index1][index2] = match_back(a, b, index1-1, index2-1, mem);
            return mem[index1][index2];
        }else if(a.charAt(index1) - 32 == b.charAt(index2)){
        	mem[index1][index2] = (match_back(a, b, index1-1, index2-1, mem) == 2)
        			|| (match_back(a, b, index1-1, index2, mem) == 2) ? 2 : 1;
        	return mem[index1][index2];
        	
        }else if(a.charAt(index1) >= 97){
            //# Case 2: No match but is lowwer case, delete it, continue
            mem[index1][index2] = match_back(a, b, index1-1, index2, mem);
            return mem[index1][index2];
        }else{
            //# Case 3: No match, done
            mem[index1][index2] = 1;
            return mem[index1][index2];
        }
    }
    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        
        //### DEBUG ###//
        String a = "BFZZVHdQYHQEMNEFFRFJTQmNWHFVXRXlGTFNBqWQmyOWYWSTDSTMJRYHjBNTEWADLgHVgGIRGKFQSeCXNFNaIFAXOiQORUDROaNoJPXWZXIAABZKSZYFTDDTRGZXVZZNWNRHMvSTGEQCYAJSFvbqivjuqvuzafvwwifnrlcxgbjmigkms";
        String b = "BFZZVHQYHQEMNEFFRFJTQNWHFVXRXGTFNBWQOWYWSTDSTMJRYHBNTEWADLHVGIRGKFQSCXNFNIFAXOQORUDRONJPXWZXIAABZKSZYFTDDTRGZXVZZNWNRHMSTGEQCYAJSF";
        System.out.println(abbreviation(a, b));
        
//        int q = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

//        for (int qItr = 0; qItr < q; qItr++) {
//            String a = scanner.nextLine();
//
//            String b = scanner.nextLine();
//            
//            //### DEBUG ###//
//            String a = "XXVVnDEFYgYeMXzWINQYHAQKKOZEYgSRCzLZAmUYGUGILjMDET";
//            String b = 
//
//            String result = abbreviation(a, b);
//
//            bufferedWriter.write(result);
//            bufferedWriter.newLine();
//        }

        //bufferedWriter.close();

        scanner.close();
    }
}
