/*
Given an array of integers, find the length of the longest (strictly) increasing subsequence from the given array.

Example 1:

Input:
N = 16
A = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15}
Output: 
6
Explanation:
There are more than one LIS in this array. One such Longest increasing subsequence is {0,2,6,9,13,15}.
Example 2:

Input:
N = 6
A[] = {5,8,3,7,9,1}
Output: 
3
Explanation:
There are more than one LIS in this array.  One such Longest increasing subsequence is {5,7,9}.
Your Task:
Complete the function longestSubsequence() which takes the input array and its size as input parameters and returns the length of the longest increasing subsequence.

Expected Time Complexity : O( N*log(N) )
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 104
0 ≤ A[i] ≤ 106
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class P20230812LongestIncreasingSubsequence{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
            
		//taking size of array
		int n = sc.nextInt();
		int array[] = new int[n];
		
		//inserting elements in the array
		for (int i = 0; i < n; ++i)
		{
			array[i] = sc.nextInt();
		}
		
		//creating an object of class Solution
		Solution ob = new Solution();
		
		//calling longestSubsequence() method of class
		//Solution
		System.out.println(ob.longestSubsequence(n,array));
    } 
} 
// } Driver Code Ends



class Solution {
    // Function to find the length of longest increasing subsequence.
    static int longestSubsequence(int n, int arr[]) {
        int tail[] = new int[n];
        int len = 0;
        for (int i = 0; i < n; i++) {
            int idx = binarySearch(tail, 0, len - 1, arr[i]);
            tail[idx] = arr[i];
            if (idx == len) {
                len++;
            }
        }
        return len;
    }

    static int binarySearch(int tail[], int l, int r, int x) {
        while (r >= l) {
            int m = l + (r - l) / 2;
            if (tail[m] == x) {
                return m;
            } else if (tail[m] < x) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}


/*
Custom Input
16
0 8 4 12 2 10 6 14 1 9 5 13 3 11 7 15
Output
6
*/