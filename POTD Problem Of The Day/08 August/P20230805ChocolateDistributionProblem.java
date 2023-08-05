/*
Given an array A[ ] of positive integers of size N, where each value represents the number of chocolates in a packet. Each packet can have a variable number of chocolates. There are M students, the task is to distribute chocolate packets among M students such that :
1. Each student gets exactly one packet.
2. The difference between maximum number of chocolates given to a student and minimum number of chocolates given to a student is minimum.

Example 1:

Input:
N = 8, M = 5
A = {3, 4, 1, 9, 56, 7, 9, 12}
Output: 6
Explanation: The minimum difference between maximum chocolates and minimum chocolates is 9 - 3 = 6 by choosing following M packets :{3, 4, 9, 7, 9}.
Example 2:

Input:
N = 7, M = 3
A = {7, 3, 2, 4, 9, 12, 56}
Output: 2
Explanation: The minimum difference between maximum chocolates and minimum chocolates is 4 - 2 = 2 by choosing following M packets :{3, 2, 4}.
Your Task:
You don't need to take any input or print anything. Your task is to complete the function findMinDiff() which takes array A[ ], N and M as input parameters and returns the minimum possible difference between maximum number of chocolates given to a student and minimum number of chocolates given to a student.

Expected Time Complexity: O(N*Log(N))
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 105
1 ≤ Ai ≤ 109
1 ≤ M ≤ N
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class P20230805ChocolateDistributionProblem
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 0;i<n;i++)
		{
			int x = sc.nextInt();
			arr.add(x);
		}
		int m = sc.nextInt();
		
		Solution ob = new Solution();
		System.out.println(ob.findMinDiff(arr,n,m));
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    void buildHeap(Integer arr[], int n)
    {
        int len=(n/2)-1;
        for(int i=len; i>=0; i--){
            heapify(arr,n,i);
        }
    }
 
    //Heapify function to maintain heap property.
    void heapify(Integer arr[], int n, int i)
    {
        int largest = i;
        int l = i*2+1;
        int r = i*2+2;
        
        if(l<n && arr[l]>arr[largest])
            largest=l;
        
        if(r<n && arr[r]>arr[largest])
            largest=r;
        
        if(largest != i){
            int swap = arr[largest];
            arr[largest] = arr[i];
            arr[i] = swap;
            
            heapify(arr,n,largest);
        }
    }
    
    //Function to sort an array using Heap Sort.
    public void heapSort(Integer arr[], int n)
    {
        buildHeap(arr,n);
        
        /*for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        */
        
        for(int i = n-1; i>0; i--){
            int swap = arr[i];
            arr[i]=arr[0];
            arr[0]=swap;
            
            heapify(arr,i,0);
        }
    }
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        // your code here
        
        //converting ArrayList to Array to reuse the heap sort alogorithm
        Integer[] arr = new Integer[a.size()];
        arr = a.toArray(arr);
        
        //using HeapSort as even the worst case time complexity is N*LogN
        heapSort(arr,n);
        
        //initializing min with largest Long value
        long min = Long.MAX_VALUE;
        
        
        //starting with (m-1)th index and comparing values based on its the previous mth index value.
        //if it is less, update min
        for(int i=m-1; i<n; i++){
            if(arr[i]-arr[i-m+1]<min){
                min=arr[i]-arr[i-m+1];
            }
        }
        
        return min;
    }
}