/*
Given a binary tree of size  N, a node, and a positive integer k., Your task is to complete the function kthAncestor(), the function should return the kth ancestor of the given node in the binary tree. If there does not exist any such ancestor then return -1.
Note: It is guaranteed that the node exists in the tree.

Example 1:



Input:
K = 2 Node = 4
Output: 1
Explanation:
Since, K is 2 and node is 4, so we
first need to locate the node and
look k times its ancestors.
Here in this Case node 4 has 1 as his
2nd Ancestor aka the Root of the tree.
Example 2:

Input:
k=1 
node=3
      1
    /   \
    2     3

Output:
1
Explanation:
K=1 and node=3 ,Kth ancestor of node 3 is 1.
Your Task:
You are asked to complete the function kthAncestor() which accepts root of the tree, k and node as input parameters, and returns the kth ancestor of Node which contains node as its value.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1<=N<=105
1<= K <= 100
1 <= Node.data <= N
*/

//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class P20230726KthAncestorInATree {
    
    static Node buildTree(String str){
        
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
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String arr[] = br.readLine().split(" ");
		int k = Integer.parseInt(arr[0]);
		int node = Integer.parseInt(arr[1]);
		String s = br.readLine();
		Node root = buildTree(s);
		
		Solution g = new Solution();
		System.out.println(g.kthAncestor(root,k,node));
    }
}
// } Driver Code Ends


//User function Template for Java

/*
Structure of Node class is:

class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}
*/

class Solution
{
    public int kthAncestor(Node root, int k, int node)
    {
        //Write your code here
        
        //map to store <child,parent> data
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int key=root.data;
        
        //function call to fill the map with tree value
        fillNode(map,root);
        
        //while the kth node is not reached
        while(k-- >0){
            
            //since get() returns null in case there is no value for the specified key,
            //therefore putting it inside try block
            try{
                node=map.get(node);
            }
            //returning -1 if any Exception is raised
            //i.e. there exist no parent/ancestor for the current node.
            catch(Exception e){
                return -1;
            }
            
            //if node value is equal to root data value but k!=0 then return -1
            if(node==key && k>0)
                return -1;
        }
        
        //lastly return the node value after iterating the above steps k times
        return node;
    }
    
    public static void fillNode(Map map, Node root){
        if(root==null)
            return;
        
        //if root.left is not null, then add the data to the map.
        if(root.left!=null)
            map.put(root.left.data,root.data);
        //if root.right is not null, then add the data to the map.
        if(root.right!=null)
            map.put(root.right.data,root.data);
        
        //explore the left node
        fillNode(map,root.left);
        
        //explore the right node
        fillNode(map,root.right);
    }
}