/*
Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s only. The task is to segregate 0s, 1s, and 2s linked list such that all zeros segregate to head side, 2s at the end of the linked list, and 1s in the mid of 0s and 2s.

Example 1:

Input:
N = 8
value[] = {1,2,2,1,2,0,2,2}
Output: 0 1 1 2 2 2 2 2
Explanation: All the 0s are segregated
to the left end of the linked list,
2s to the right end of the list, and
1s in between.
Example 2:

Input:
N = 4
value[] = {2,2,0,1}
Output: 0 1 2 2
Explanation: After arranging all the
0s,1s and 2s in the given format,
the output will be 0 1 2 2.
Your Task:
The task is to complete the function segregate() which segregates the nodes in the linked list as asked in the problem statement and returns the head of the modified linked list. The printing is done automatically by the driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 106

*/


//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class P20230723GivenALinkedListOf0s1sAnd2s_SortIt
{
    public static void main (String[] args) throws IOException
    {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int temp = sc.nextInt();
		Node head = new Node(temp);
		Node tail = head;
		for (int i = 1; i < n; i++) {
			temp = sc.nextInt();
			tail.next = new Node(temp);
			tail = tail.next;
		}

		head = new Solution().segregate(head);
		printList(head);
		System.out.println();
    }
    
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}




// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        // add your code here
        
        /*
        //Approach 1
        Node temp=head, zeros=null, zhead=null, ones=null, ohead=null, twos=null, thead=null;
        
        while(temp!=null){
            if(temp.data==0){
                if(zeros==null){
                    zeros=temp;
                    zhead=temp;
                }
                else{
                    zeros.next=temp;
                    zeros=temp;
                }
            }
            else if(temp.data==1){
                if(ones==null){
                    ones=temp;
                    ohead=temp;
                }
                else{
                    ones.next=temp;
                    ones=temp;
                }
            }
            else{
                if(twos==null){
                    twos=temp;
                    thead=temp;
                }
                else{
                    twos.next=temp;
                    twos=temp;
                }
            }
            
            
            temp=temp.next;
        }
        
        if(zeros==null)
        {
            if(ones==null){
                zhead=thead;
            }
            else{
                zhead=ohead;
            }
        }
        
        if(ones==null){
            zeros.next=thead;
        }
        
            ones.next=thead;
        
        
        
        return zhead;
        
        
        
        //Approach1 ends.
        */
        
        
        //Approach 2
        
        int count0=0,count1=0,count2=0;
        Node temp=head;
        while(temp!=null){
            if(temp.data==0){
            count0++;
            temp=temp.next;
            }
            else if(temp.data==1){
            count1++;
            temp=temp.next;
            }
            else if(temp.data==2){
            count2++;
            temp=temp.next;
            }
        }
        
        Node temp2=head;
        while(temp2!=null){
            if(count0>0){
            temp2.data=0;
            temp2=temp2.next;
            count0--;
            }
            else if(count0==0 && count1>0){
            temp2.data=1;
            temp2=temp2.next;
            count1--;
            }
            else if(count1==0 && count2>0){
            temp2.data=2;
            temp2=temp2.next;
            count2--;
            }
        }
        
        return head;
        
    }
}