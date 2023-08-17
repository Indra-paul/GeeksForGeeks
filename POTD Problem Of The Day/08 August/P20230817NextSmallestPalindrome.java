/*
Given a number, in the form of an array Num[] of size N containing digits from 1 to 9(inclusive). The task is to find the next smallest palindrome strictly larger than the given number.

Example 1:

Input:
N = 11
Num[] = {9, 4, 1, 8, 7, 9, 7, 8, 3, 2, 2}
Output: 9 4 1 8 8 0 8 8 1 4 9
Explanation: Next smallest palindrome is
94188088149.
Example 2:

Input:
N = 5
Num[] = {2, 3, 5, 4, 5}
Output: 2 3 6 3 2
Explanation: Next smallest palindrome is
23632.
Your Task:
Complete the function generateNextPalindrome() which takes an array num, and an single integer n, as input parameters and returns an array of integers denoting the answer. You don't to print answer or take inputs.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 105
1 <= Num[i] <= 9
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class P20230817NextSmallestPalindrome {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		int num[] = new int[n];
		String[] str = br.readLine().trim().split(" ");
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(str[i]);
		}

		Vector<Integer> ans = new Solution().generateNextPalindrome(num, n);
		for (Integer x : ans) {
			System.out.print(x + " ");
		}
		System.out.println();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    Vector<Integer> generateNextPalindrome(int num[], int n) {
        // code here
        int m=n/2;
        int l=m-1;
        int r=(n%2==1) ? m+1:m;
        while(l>=0 && num[l]==num[r]) {
            l--;
            r++;
        }
        Vector<Integer> v=new Vector<Integer>();
        int carry=0;
        if(l<0 || num[l]<num[r]) {
            carry=1;
        }
        l=m;
        if(n%2==0) {
            l=m-1;
        }
        r=m;
        while(l>=0) {
            num[l]+=+carry;
            carry=num[l]/10;
            num[l]%=10;
            num[r]=num[l];
            l--;
            r++;
        }
        if(carry==1) {
            num[n-1]=1;
            v.addElement(1);
        }
        for(int ele:num) {
            v.add(ele);
        }
        return v;
    }
}

/*
Input:
3
9 9 9
Output:
1 0 0 1
*/