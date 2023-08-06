/*
Given a string S. The task is to find all permutations (need not be different) of a given string.

Example 1:

Input:
S = AAA
Output: AAA AAA AAA AAA AAA AAA
Explanation: There are total 6 permutations, as given in the output.
Example 2:

Input:
S = ABSG
Output: ABGS ABSG AGBS AGSB ASBG ASGB
BAGS BASG BGAS BGSA BSAG BSGA GABS
GASB GBAS GBSA GSAB GSBA SABG SAGB
SBAG SBGA SGAB SGBA
Explanation: There are total 24 permutations, as given in the output.
Your Task:
This is a function problem. You only need to complete the function permutation that takes S as parameter and returns the list of permutations in lexicographically increasing order. The newline is automatically added by driver code.

Constraints:
1 ≤ size of string ≤ 5

Expected Time Complexity: O(N * N!), N = length of string.
Expected Auxiliary Space: O(1)
*/

//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class P20230806StringPermutation {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);

		Solution ob=new Solution();
		
		String S=sc.nextLine();
		
		ArrayList<String> arr = ob.permutation(S);
		for(String s : arr){
			System.out.print(s+" ");
		}
		System.out.println();
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public ArrayList<String> permutation(String S)
    {
        //Your code here
        
        //S=sort(S);
        ArrayList <String> res = new ArrayList<>();
        reccursivePermutation(res,S,"");
        Collections.sort(res);
        return res;
    }
    
    public static void reccursivePermutation(ArrayList<String> res, String S, String str){
        if(S.length()==0){
            res.add(str);
            return;
        }
        
        for(int i=S.length()-1; i>=0; i--){
            char ch = S.charAt(i);
            String newStr = S.substring(0,i)+S.substring(i+1);
            reccursivePermutation(res,newStr,ch+str);
        }
    }

    /*
    public static String sort(String S){
        char ch[] = S.toCharArray();
        int i, j;
        char min, temp;
        for(i=0; i<ch.length-1; i++){
            min=ch[i];
            for(j=i+1; j<ch.length; j++){
                if(min>ch[j])
                    min=ch[j];
            }
            if(min!=ch[i]){
                temp=ch[i];
                ch[i]=min;
                min=temp;
            }
        }
        return new String(ch);
    }
    */	   
}
