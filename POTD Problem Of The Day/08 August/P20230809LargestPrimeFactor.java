/*
Given a number N, the task is to find the largest prime factor of that number.
 Example 1:

Input:
N = 5
Output:
5
Explanation:
5 has 1 prime factor i.e 5 only.
Example 2:

Input:
N = 24
Output:
3
Explanation:
24 has 2 prime factors 2 and 3 in which 3 is greater.
Your Task:
You don't need to read input or print anything. Your task is to complete the function largestPrimeFactor() which takes an integer N as input parameters and returns an integer, largest prime factor of N.

Expected Time Complexity: O(sqrt(N))
Expected Space Complexity: O(1)

Constraints:
2 <= N <= 109
*/

//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class P20230809LargestPrimeFactor
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(read.readLine());
		Solution ob = new Solution();
		System.out.println(ob.largestPrimeFactor(N));
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long largestPrimeFactor(int N) {
        long largestPrime = -1; // Initialize to a negative value

    if (N == 1) {
        return 1; // Special case for N = 1
    }

    // Divide N by 2 until it becomes odd
    while (N % 2 == 0) {
        largestPrime = 2;
        N /= 2;
    }

    // Now N is odd, check for prime factors starting from 3 and increment step by two
    for (int i = 3; i <= Math.sqrt(N); i += 2) {
        //keep on dividing the current value which will eliminate the factors for prime numbers
        //simultaneously divide N by the current value of i
        while (N % i == 0) {
            largestPrime = i;
            N /= i;
        }
    }

    // After completing the above loop, If N is still greater than 2, then largestPrime is N
    // for example N=60, after dividing by 2 N=15, after above loop, N=5
    if (N > 2) {
        largestPrime = N;
    }

    return largestPrime;
    }
}

/*
Custom Input
24
Output
3
*/