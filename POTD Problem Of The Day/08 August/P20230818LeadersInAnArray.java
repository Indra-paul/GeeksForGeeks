/*
Given an array A of positive integers. Your task is to find the leaders in the array. An element of array is leader if it is greater than or equal to all the elements to its right side. The rightmost element is always a leader. 

Example 1:

Input:
n = 6
A[] = {16,17,4,3,5,2}
Output: 17 5 2
Explanation: The first leader is 17 
as it is greater than all the elements
to its right.  Similarly, the next 
leader is 5. The right most element 
is always a leader so it is also 
included.
Example 2:

Input:
n = 5
A[] = {1,2,3,4,0}
Output: 4 0
Explanation: 0 is the rightmost element
and 4 is the only element which is greater
than all the elements to its right.
Your Task:
You don't need to read input or print anything. The task is to complete the function leader() which takes array A and n as input parameters and returns an array of leaders in order of their appearance.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(n)

Constraints:
1 <= n <= 107
0 <= Ai <= 107
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.stream.*;

class P20230818LeadersInAnArray {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter ot = new PrintWriter(System.out);
    
		//input size of array
		int n = Integer.parseInt(br.readLine().trim());
		int arr[] = new int[n];
		String inputLine[] = br.readLine().trim().split(" ");
		
		//inserting elements in the array
		for(int i=0; i<n; i++){
			arr[i] = Integer.parseInt(inputLine[i]);
		}
		
		Solution obj = new Solution();
		
		StringBuffer str = new StringBuffer();
		ArrayList<Integer> res = new ArrayList<Integer>();
	  
		//calling leaders() function
		res = obj.leaders(arr, n);
		

		for(int i=0; i<res.size(); i++){
			ot.print(res.get(i)+" ");
		}
		
		ot.println();
		ot.close();
		
	}
}

// } Driver Code Ends


class Solution{
    //Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        
		//stack to store the result so that it can be traversed backwards,
		//when elements will be poped one by one
        Stack<Integer> st = new Stack<>();
		
		//since the rightmost element is always a Leader, store it max and stack.
        int max=arr[n-1];
        st.push(max);
		
		//traversing the array from end
		//storing the element in the stack if it is greater than max i.e. a leader
		//and updating the max element
        for(int i=n-2; i>=0; i--){
            if(arr[i]>=max){
                max=arr[i];
                st.push(max);
            }
        }
        
        //creating an Arraylist to store the leader and return
        ArrayList<Integer> ar = new ArrayList<>();
		
		//while stack is not empty, store the popped element in the ArrayList
        while(!st.isEmpty()){
            ar.add(st.pop());
        }
        
		//return ArrayList
        return ar;
    }
}



/*
Input 1:
3
10 10 10
Output:
10 10 10

Input 2:
6
16 17 4 3 5 2
Output:
17 5 2
*/