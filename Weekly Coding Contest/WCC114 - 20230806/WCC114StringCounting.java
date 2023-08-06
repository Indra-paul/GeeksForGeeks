/*
Given a string s, you choose some substring s[l...r] (1 ≤ l ≤ r ≤ |s|) exactly once and reverse it. For example, in the string geeks, select the substring s[2...4], after performing the mentioned operation, the new string will be gkees.

Count the number of unique strings that can be obtained by doing this operation exactly once.

Example 1:

Input:
s = "abaaa"
Output: 
5
Explanation: 
Take every possible substring and operate on it.
Possible strings after doing the operation are:
"baaaa", "abaaa", "aabaa", "aaaba" and "aaaab".
Example 2:

Input:
s = "aaaaaa"
Output: 
1
Explanation: 
Take any substring and reverse it, the resultant string will be same as the given string.
Your Task:
You don't need to read input or print anything. Your task is to complete the function countStrings( ) which takes string s as an input parameter and returns the answer.

Constraints: 
1 ≤ |s| ≤ 106
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class WCC114StringCounting
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine().trim();
		Solution ob = new Solution();
		
		System.out.println(ob.countStrings(S));
	}
}
// } Driver Code Ends

//User function Template for Java

class Solution {
    public long countStrings(String s) {
        int n = s.length();
        Set<String> uniqueStrings = new HashSet<>();
        
        for (int j = 0; j <= n; j++) {
            for (int k = 0; k <= j; k++) {
                StringBuilder sb = new StringBuilder(s);
                
                // Reversing the substring s[k...j-1] in-place
                for (int i = k, m = j - 1; i < m; i++, m--) {
                    char temp = sb.charAt(i);
                    sb.setCharAt(i, sb.charAt(m));
                    sb.setCharAt(m, temp);
                }
                
                uniqueStrings.add(sb.toString());
            }
        }
        
        return uniqueStrings.size();
    }
}