/*
Given a BST, and a reference to a Node x in the BST. Find the Inorder Successor of the given node in the BST.
 

Example 1:

Input:
      2
    /   \
   1     3
K(data of x) = 2
Output: 3 
Explanation: 
Inorder traversal : 1 2 3 
Hence, inorder successor of 2 is 3.

Example 2:

Input:
             20
            /   \
           8     22
          / \
         4   12
            /  \
           10   14
K(data of x) = 8
Output: 10
Explanation:
Inorder traversal: 4 8 10 12 14 20 22
Hence, successor of 8 is 10.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function inOrderSuccessor(). This function takes the root node and the reference node as argument and returns the node that is inOrder successor of the reference node. If there is no successor, return null value.


Expected Time Complexity: O(Height of the BST).
Expected Auxiliary Space: O(1).


Constraints:
1 <= N <= 105, where N is number of nodes
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}

class P20230730InorderSuccessorinBST {
    
    static Node buildTree(String str)
    {
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }

    public static Node search(Node root,int x){
		if(root==null||root.data==x)
			return root;
		if(root.data>x)
			return search(root.left,x);
		return search(root.right,x);
	}

	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		Node root = buildTree(s);
		
		int k=Integer.parseInt(br.readLine());
		Node kNode = search(root,k);
		
		Solution g = new Solution();
		Node x = g.inorderSuccessor(root,kNode);
		
		if(x==null) System.out.println("-1");
		else System.out.println(x.data);

    }
}
// } Driver Code Ends
class Solution
{
    
    // returns the inorder successor of the Node x in BST (rooted at 'root')
	public Node inorderSuccessor(Node root,Node x)
	{
		//add code here.
		// inorderSuc to store the inorder Successor of the Node x.
		Node inorderSuc = null;
		
		//traverse while x node is not found
		while(root.data != x.data){
			
			if(x.data<root.data){	//if current node.data < x.data
				inorderSuc = root;	//store the current node in inorderSuc 
				root=root.left;		//move to the left node
			}
				
			else
				root=root.right;	//move to right node if current node.data > x.data
				
		}
		
		//at this point, we will have information about Node x.
		if(root.right!=null){				//if current node has right child
			inorderSuc=root.right;			//update inorderSuc with the right child
			while(inorderSuc.left!=null){	//traverse till inorderSuc's left child doesn't become null.
				inorderSuc=inorderSuc.left;
			}
		}
		
		//at this point inorderSuc will only be null if and only if Node x is the right most Node in the BST
		return inorderSuc;
		
	}
}