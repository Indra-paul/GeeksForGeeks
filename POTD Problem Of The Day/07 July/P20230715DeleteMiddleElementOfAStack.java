/*
Given a stack, delete the middle element of the stack without using any additional data structure.
Middle element:- ceil((size_of_stack+1)/2) (1-based indexing) from bottom of the stack.

Note: The output shown by the compiler is the stack from top to bottom.
 
Example 1:

Input: 
Stack = {10, 20, 30, 40, 50}
Output:
ModifiedStack = {10, 20, 40, 50}
Explanation:
If you print the stack the bottom-most element will be 10 and the top-most element will be 50. Middle element will be element at index 3 from bottom, which is 30. Deleting 30, stack will look like {10 20 40 50}.
Example 2:

Input: 
Stack = {10 20 30 40}
Output:
ModifiedStack = {10 30 40}
Explanation:
If you print the stack the bottom-most element will be 10 and the top-most element will be 40. Middle element will be element at index 2 from bottom, which is 20. Deleting 20, stack will look like {10 30 40}.
Your Task:
You don't need to read input or print anything. Complete the function deleteMid() which takes the stack and its size as input parameters and modifies the stack in-place.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
2 ≤ size of stack ≤ 105
*/

import java.util.*;
import java.io.*;

public class P20230715DeleteMiddleElementOfAStack{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int sizeOfStack =sc.nextInt();
        Stack <Integer> myStack=new Stack<>();
            
        //adding elements to the stack
        for(int i=0;i<sizeOfStack;i++){
            int x=sc.nextInt();
            myStack.push(x);
        }
		Solution obj=new Solution();
		obj.deleteMid(myStack,sizeOfStack);
		
		while(!myStack.isEmpty())
		{
			System.out.print(myStack.peek()+" ");
			myStack.pop();
		}
		
	}
}

class Solution
{
    //Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer>s,int sizeOfStack){
        // code here
        
        Stack<Integer> st = new Stack<>();	//a temporary stack created for this operation. Will be destroyed once the function gets executed.
		
        int len = (int)Math.ceil(((float)sizeOfStack+1)/2);
        //float type conversion used since sezeOfStack type is int and dividing it by 2 will result in depricating the decimal part.
		//return type of Math.ceil is double hence explicitly converting it to int
		
        for(int i=1; i<len; i++){
            st.push(s.pop());		//adding element from top of s till mid-1 to the temporiraly created Stack st.
        }
        
        s.pop();					//popping the middle element from stack s.
        
        while(!st.isEmpty()){
            s.push(st.pop());		//transfering the elements back to s from st.
        }
        
    } 
}

/*
5
10 20 30 40 50
50 40 20 10
*/