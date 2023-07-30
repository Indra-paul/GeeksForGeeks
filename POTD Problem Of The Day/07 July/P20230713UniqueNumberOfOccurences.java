/*
Given an array arr of N integers, the task is to check whether the frequency of the elements in the array is unique or not. Or in other words, there are no two distinct numbers in array with equal frequency. If all the frequency is unique then return true, else return false.

Example 1:

Input:
N = 5
arr = [1, 1, 2, 5, 5]
Output:
false
Explanation:
The array contains 2 (1’s), 1 (2’s) and 2 (5’s), since the number of frequency of 1 and 5 are the same i.e. 2 times. Therefore, this array does not satisfy the condition.
Example 2:

Input:
N = 10
arr = [2, 2, 5, 10, 1, 2, 10, 5, 10, 2]
Output:
true
Explanation:
Number of 1’s -> 1
Number of 2’s -> 4
Number of 5’s -> 2
Number of 10’s -> 3.
Since, the number of occurrences of elements present in the array is unique. Therefore, this array satisfy the condition.
Your task:
You don't need to read input or print anything. Your task is to complete the function isFrequencyUnique() which take integer N and array arr of size N as arguments, and returns a boolean.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 <= N <=105
-109 <= arr[i] <= 109*/


//{ Driver Code Starts
//Initial Template for Java

//Driver code changed so that the code can be executed at the local machine.

import java.io.*;
import java.util.*;
import java.util.*;

class P20230713UniqueNumberOfOccurences
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
		int a[] = new int[t];
        for(int i=0; i<t; i++){
			a[i]=sc.nextInt();
		}
		Solution s = new Solution();
		System.out.println(s.isFrequencyUnique(t,a));
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    public static boolean isFrequencyUnique(int n, int[] arr) {
        // code here
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<n; i++){
            Integer a = map.get(arr[i]);
            if(a!=null)
                map.put(arr[i],a+1);
            else
                map.put(arr[i],1);
        }
        
        Map<Integer, Integer> uniqueval = new HashMap<>();
        
        for(Integer val : map.values()){
            if(!uniqueval.containsKey(val)){
                uniqueval.put(val,0);
            }
            else
                return false;
        }
        return true;
    }
}