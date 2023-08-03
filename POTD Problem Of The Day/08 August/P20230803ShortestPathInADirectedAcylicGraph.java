/*
Given a Directed Acyclic Graph of N vertices from 0 to N-1 and a 2D Integer array(or vector) edges[ ][ ] of length M, where there is a directed edge from edge[i][0] to edge[i][1] with a distance of edge[i][2] for all i.

Find the shortest path from src(0) vertex to all the vertices and if it is impossible to reach any vertex, then return -1 for that vertex.

Example1:

Input:
N = 4, M = 2
edge = [[0,1,2],[0,2,1]
Output:
0 2 1 -1
Explanation:
Shortest path from 0 to 1 is 0->1 with edge weight 2. 
Shortest path from 0 to 2 is 0->2 with edge weight 1.
There is no way we can reach 3, so it's -1 for 3.
Example2:

Input:
N = 6, M = 7
edge = [[0,1,2],[0,4,1],[4,5,4],[4,2,2],[1,2,3],[2,3,6],[5,3,1]]
Output:
0 2 3 6 1 5
Explanation:
Shortest path from 0 to 1 is 0->1 with edge weight 2. 
Shortest path from 0 to 2 is 0->4->2 with edge weight 1+2=3.
Shortest path from 0 to 3 is 0->4->5->3 with edge weight 1+4+1=6.
Shortest path from 0 to 4 is 0->4 with edge weight 1.
Shortest path from 0 to 5 is 0->4->5 with edge weight 1+4=5.
Your Task:

You don't need to print or input anything. Complete the function shortest path() which takes an integer N as number of vertices, an integer M as number of edges and a 2D Integer array(or vector) edges as the input parameters and returns an integer array(or vector), denoting the list of distance from src to all nodes.

Expected Time Complexity: O(N+M), where N is the number of nodes and M is edges
Expected Space Complexity: O(N)

Constraint:
1 <= N,M <= 100
0 <= edgei,0,edgei,1 < n
0 <= edgei,2 <=105
*/

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class P20230803ShortestPathInADirectedAcylicGraph {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] edge = new int[m][3];
		for (int i = 0; i < m; i++) {
			edge[i][0] = sc.nextInt();
			edge[i][1] = sc.nextInt();
			edge[i][2] = sc.nextInt();
		}
		Solution obj = new Solution();
		int res[] = obj.shortestPath(n, m,edge);
		for (int i = 0; i < n; i++) {
			System.out.print(res[i] + " ");
		}
		System.out.println();
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here

        int dist[] = new int[N];
        
        //fill the array with the maximum value of int
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        //set the 0th element value to 0
        dist[0]=0;
        boolean flag;
        
        //run the loop to M-1 times
        //M-1 because we are updating the dist[dest],
        //meaning when we will be in the M-2 iteration, value for dest node i.e. M-1 node will be updated.
        //There is no harm if we continue the till M but this will include unnecessary iteration.
        for(int i=0;i<M-1;i++)
        {
            flag=true;              //set to true at begginning of each iteration
            for(int [] val:edges)
            {
                int src=val[0];
                int dest=val[1];
                int w = val[2];
                
                //check if distance of source and edge weight is less than destination distance.
                //ignore if source is unreachable or above condition is not satisfied
                if(dist[src]!=Integer.MAX_VALUE && dist[src]+w<dist[dest])
                {
                    flag=false;     //set flag to flase if any update during the iteration
                    dist[dest]=dist[src]+w;     //update destination distance with the lowest value
                }
            }
            if(flag)                //if true, mean that was no update during the previous iteration
                break;              // hence exit from the loop
        }
        
        
        //loop to change the value to -1 for unreachable nodes 
        for(int i=0;i<N;i++)
        {
            if(dist[i]==Integer.MAX_VALUE)dist[i]=-1;
        }
        
        //return  integer array dist
        return dist;
	}
}