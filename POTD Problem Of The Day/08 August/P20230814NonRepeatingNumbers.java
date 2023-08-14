/*
Given an array A containing 2*N+2 positive numbers, out of which 2*N numbers exist in pairs whereas the other two number occur exactly once and are distinct. Find the other two numbers. Return in increasing order.

Example 1:

Input: 
N = 2
arr[] = {1, 2, 3, 2, 1, 4}
Output:
3 4 
Explanation:
3 and 4 occur exactly once.
Example 2:

Input:
N = 1
arr[] = {2, 1, 3, 2}
Output:
1 3
Explanation:
1 3 occur exactly once.
Your Task:
You do not need to read or print anything. Your task is to complete the function singleNumber() which takes the array as input parameter and returns a list of two numbers which occur exactly once in the array. The list must be in ascending order.

Expected Time Complexity: O(N)
Expected Space Complexity: O(1)

Constraints:
1 <= length of array <= 106 
1 <= Elements in array <= 5 * 106
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class P20230814NonRepeatingNumbers
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		String s = br.readLine();
		String[] S = s.split(" ");
		int[] v = new int[2 * n + 2];
		for(int i = 0; i < 2 * n + 2; i++)
		{
			v[i] = Integer.parseInt(S[i]);
		}
		Solution ob = new Solution();
		int[] ans = ob.singleNumber(v);
		for(int i = 0; i < ans.length; i++)
			System.out.print(ans[i] + " ");
		System.out.println();
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] singleNumber(int[] nums)
    {
        // Code here
        
        int len = nums.length;
        Map<Integer,Integer> hashMap = new HashMap<>();
        
        for(int i=0; i<len; i++){
            if(hashMap.containsKey(nums[i]))
                hashMap.remove(nums[i]);
            else
                hashMap.put(nums[i],i);
        }
        
        Iterator<Integer> it = hashMap.keySet().iterator();
        
        int a[] = new int[2];
        int num1=(int)it.next(), num2=(int)it.next();
        if(num1>num2){
            a[0]=num2;
            a[1]=num1;
        }
        else{
            a[0]=num1;
            a[1]=num2;
        }
        
        return a;
    }
}

/*
Custom Input
2
1 2 3 2 1 4
Output
3 4
*/