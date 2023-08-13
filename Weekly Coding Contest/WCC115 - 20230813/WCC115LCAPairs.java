/*
You are given a connected tree of N nodes numbered from 0 to N-1 rooted at the 0th node, where p[i] is the parent of the ith node and p[0] = -1 as the 0th node is the root.

Calculate the numbers of pairs of nodes (a,b) 0 < a < N, a < b < N such that LCA(a,b) = x , for each x where 0 < x < N.

The LCA or lowest common ancestor between two nodes a and b is defined as the lowest node in tree that has both a and b as descendants (where we allow a node to be a descendant of itself).

Example 1:

Input: 
N = 3 
p[] = [-1, 0, 0]    
Output: [4, 1 , 1]
Explanation: The structure of tree is :
   0
  / \
 1   2
For LCA = 0, we have 4 pairs (0,0), (0,1),
(0,2), (1,2)
For LCA = 1, we have only 1 pair (1,1)
For LCA = 2, we have only 1 pair (2,2)
Example 2:

Input:
N = 5
p[] = [-1, 0, 0, 1, 1]
Output: [8, 4, 1, 1, 1]
Explanation: The structure of tree is :
      0 
     / \
    1   2
   / \
  3   4
For LCA = 0, we have 8 pairs (0,0), (0,1),
(0,2),(0,3),(0,4),(1,2),(2,3),(2,4)
For LCA = 1 , we have 4 pairs (1,1), (1,3),
(1,4),(3,4)
FOR LCA = 2, we have only 1 pair (2,2),
FOR LCA = 3, we have only 1 pair (3,3)
For LCA = 4, we have only 1 pair (4,4)

Your Task: 
Your task is to complete the function calcPairs() which takes the integer N  and a list p[ ] of size N as input parameters and returns  a list of N elements a0, a1, .. aN-1 where ai is the the number of unordered pairs for which lca(a,b) = i , where 0 < a < N , a < b < N



Constraints:
1 ≤ N ≤ 105
0 < p[i] < N where 0< i < N
p[0]=-1
*/


//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class WCC115LCAPairs
{
    public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<Integer>() ;
		
		
		String line = br.readLine();
		String[] elements = line.trim().split(" ");
		
		for(int index = 0;index < n; index++){
			arr.add(Integer.parseInt(elements[index]));
		}
		
		Solution obj = new Solution();
		ArrayList<Long> ans = obj.calcPairs(n, arr) ;
		for(long x : ans) {
			System.out.print(x+" ");
		}
		out.println();
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    public ArrayList<Long> calcPairs(int N, ArrayList<Integer> p) {
        long[] res = new long[N]; // Use primitive long array
        
        // Calculate LCA for each pair and increment ancestor's count
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int parentNode = findLCA(p, i, j);
                if (parentNode != -1) {
                    res[parentNode]++;
                }
            }
        }
        
        ArrayList<Long> array_list = new ArrayList<>(N);
        for (long val : res) {
            array_list.add(val);
        }
        
        return array_list;
    }

    public int findLCA(ArrayList<Integer> p, int node1, int node2) {
        boolean[] visited = new boolean[p.size()];

        while (node1 != -1) {
            visited[node1] = true;
            node1 = p.get(node1);
        }

        while (node2 != -1) {
            if (visited[node2]) {
                return node2;
            }
            node2 = p.get(node2);
        }

        return -1; // No common ancestor found
    }
}


/*
Custom Input
4
-1 3 0 0
Output
6 1 1 2
*/