/*
Given a positive integer n, find the nth fibonacci number. Since the answer can be very large, return the answer modulo 1000000007.

Example 1:

Input: 
n = 2
Output: 
1 
Explanation: 
1 is the 2nd number of fibonacci series.
Example 2:

Input: 
n = 5
Output: 
5
Explanation: 
5 is the 5th number of fibonacci series.
Your Task:  
You dont need to read input or print anything. Complete the function nthFibonacci() which takes n as input parameter and returns nth fibonacci number.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1<= n <=105
*/

//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class P20230813NthFibonacciNumber {
    public static void main(String args[]) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(read.readLine());
		System.out.println(Solution.nthFibonacci(n));	
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution {
    static int nthFibonacci(int n){
        // code here
        if(n==1 || n==2)
            return 1;
        
        n=n-2;
        long a=1, b=1,temp;
        while(n--!=0){
            temp=a;
            a=b;
            b=temp+b;
            b=b%1000000007;
        }
        return (int)b;
    }
}

/*Custom Input
1000000
Output
918091266
/*