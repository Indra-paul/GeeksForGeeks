/*
In Peculiar School, students are admitted based on their strength. The strength of n students is given to you in the form of an array arr. The PT teacher wants to analyse 2 sets of m students. Help him find the maximum possible difference between the sum of strengths of students in the two groups.

Note: One student can be a part of more than one group.

Example 1:

Input:
n = 5
m = 4
arr = {1, 2, 3, 4, 5}
Output: 
4
Explanation: 
Maximum difference can be achieved by making these two sets {1, 2, 3, 4} and {2, 3, 4, 5} of m=4 students.
Difference of sum of numbers of these two sets will be | (1+2+3+4) -  (2+3+4+5) | = 4.
Example 2:

Input:
n = 5
m = 2
arr = {5, 8, 40, 11, 15}
Output: 
42
Explanation: 
Maximum difference can be achieved by making these two sets {5, 8} and {40, 15} of m=2 students.
Difference of sum of numbers of these two sets will be | (5+8) -  (40+15) | = 4.
Your Task:
Complete the function diffSum() which takes 3 arguments n, m, and array of elements arr and returns the maximum difference.

Constraints: 
1 <= m <= n <= 105
1 <= arri <= 105
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class WCC114StrongStudentsInSchool
{
    public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n,m,i;
		n = sc.nextInt();
		m = sc.nextInt();
		int arr[] = new int[n];
		for(i=0;i<n;i++)
			arr[i]=sc.nextInt();
		Solution obj = new Solution();
		System.out.println(obj.diffSum(n,m,arr));
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int diffSum(int n,int m,int arr[])
    {
        //code here.
        
        heapSort(arr,n);
        int sum=0;
        
        for(int i=0; i<m; i++){
            sum= sum+arr[n-1-i]-arr[i];
        }
        
        return sum;
    }
    
    static void buildHeap(int arr[], int n)
    {
        // Your code here
        int len=(n/2)-1;
        for(int i=len; i>=0; i--){
            heapify(arr,n,i);
        }
        
        
    }
 
    //Heapify function to maintain heap property.
    static void heapify(int arr[], int n, int i)
    {
        // Your code here
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
    static public void heapSort(int arr[], int n)
    {
        //code here
        
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
}