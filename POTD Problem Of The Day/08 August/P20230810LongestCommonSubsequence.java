/*
Given two strings, find the length of longest subsequence present in both of them. Both the strings are in uppercase latin alphabets.

Example 1:

Input:
A = 6, B = 6
str1 = ABCDGH
str2 = AEDFHR
Output: 3
Explanation: LCS for input strings "ABCDGH" and "AEDFHR" is "ADH" of length 3.
Example 2:

Input:
A = 3, B = 2
str1 = ABC
str2 = AC
Output: 2
Explanation: LCS of "ABC" and "AC" is "AC" of length 2.
Your Task:
Complete the function lcs() which takes the length of two strings respectively and two strings as input parameters and returns the length of the longest subsequence present in both of them.

Expected Time Complexity : O(|str1|*|str2|)
Expected Auxiliary Space: O(|str1|*|str2|)

Constraints:
1<=size(str1),size(str2)<=103
*/

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class P20230810LongestCommonSubsequence {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int p=sc.nextInt();             // Take size of both the strings as input
		int q=sc.nextInt();
		
		String s1=sc.next();            // Take both the string as input
		String s2=sc.next();
		
		Solution obj = new Solution();
		
		System.out.println(obj.lcs(p, q, s1, s2));
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2)
    {
        // your code here
        char c1[] = s1.toCharArray(), c2[] = s2.toCharArray();
        int a[][] = new int[x+1][y+1];
        
        for(int i=1; i<=x; i++){
            for(int j=1; j<=y; j++){
                if(c1[i-1]==c2[j-1])
                    a[i][j]=1+a[i-1][j-1];
                else
                    a[i][j]=Math.max(a[i-1][j],a[i][j-1]);
                    
                //System.out.print(a[i][j]);
            }
            //System.out.println();
        }
        
        return a[x][y];
    }
    
}

/*
Custom Input
6 6
ABCDGH
AEDFHR

Output
3
*/