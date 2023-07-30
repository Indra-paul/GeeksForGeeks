/*
Given a String, find the longest palindromic subsequence.

Example 1:

Input:
S = "bbabcbcab"
Output: 7
Explanation: Subsequence "babcbab" is the
longest subsequence which is also a palindrome.
Example 2:

Input: 
S = "abcd"
Output: 1
Explanation: "a", "b", "c" and "d" are
palindromic and all have a length 1.

Your Task:
You don't need to read input or print anything. Your task is to complete the function longestPalinSubseq() which takes the string S as input and returns an integer denoting the length of the longest palindromic subsequence of S.

Expected Time Complexity: O(|S|*|S|).
Expected Auxiliary Space: O(|S|*|S|).

Constraints:
1 ≤ |S| ≤ 1000
*/


//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class P20230719LongestPalindromeSubsequence
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
			String s = sc.next();
			Solution obj = new Solution();
			System.out.println(obj.longestPalinSubseq(s));                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String st)
    {
        //code here
        char str[] = st.toCharArray();		//converting string to character array
        int n = st.length();				//length of the string
        char revStr[] = new char[n];		//creating a new character array to store reverse string
        for(int i=0; i<n; i++){
            revStr[i]=str[n-1-i];
        }
		int dp[][] = new int[n+1][n+1];
    
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=n; j++) {
				if (str[i-1] == revStr[j-1])		
					dp[i][j] = 1 + dp[i-1][j-1];	
				else
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				//System.out.print(dp[i][j]+"\t");
			}
			//System.out.println();
		}
		return dp[n][n];
    }
}