/*
Given a number N. The task is to find the Nth catalan number.
The first few Catalan numbers for N = 0, 1, 2, 3, … are 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, …

Catalan Number for N is equal to the number of expressions containing N pairs of paranthesis that are correct matched, i.e., for each of the N '(' there exist N ')' on there right and vice versa.

Since answer can be huge return answer modulo 1e9+7.

Note: Positions start from 0 as shown above.

Example 1:

Input:
N = 5
Output: 42
Example 2:

Input:
N = 4
Output: 14
Your Task:
Complete findCatalan() function that takes n as an argument and returns the Nth Catalan number. The output is printed by the driver code.

Expected Time Complexity: O(N^2).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 103
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class P20230816NthCatalanNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n;
		n = Integer.parseInt(br.readLine());
		
		Solution obj = new Solution();
		int res = obj.findCatalan(n);
		
		System.out.println(res);
    }
}

// } Driver Code Ends



class Solution {
    public static int findCatalan(int n) {
        // code here
       
        int c[] = new int[n+1];
        c[0]=c[1]=1;
        long mod=1000_000_007L;
        for(int i=2; i<=n; i++)
        {
            long ans=0;
            //c[i]=0;
            for(int j=0; j<i; j++)
            {
                ans=(ans+((long) c[j] * c[i - j - 1])%mod)%mod;
                
               
            }
            c[i]= (int) ans;
           
        }
        return c[n];
    }
}
        
/*
Input: 5
Output: 42
*/