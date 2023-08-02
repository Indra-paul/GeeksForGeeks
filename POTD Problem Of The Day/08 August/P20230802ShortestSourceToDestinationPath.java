/*
Given a 2D binary matrix A(0-based index) of dimensions NxM. Find the minimum number of steps required to reach from (0,0) to (X, Y).
Note: You can only move left, right, up and down, and only through cells that contain 1.

Example 1:

Input:
N=3, M=4
A=[[1,0,0,0], 
   [1,1,0,1],
   [0,1,1,1]]
X=2, Y=3 
Output:
5
Explanation:
The shortest path is as follows:
(0,0)->(1,0)->(1,1)->(2,1)->(2,2)->(2,3).
Example 2:

Input:
N=3, M=4
A=[[1,1,1,1],
   [0,0,0,1],
   [0,0,0,1]]
X=0, Y=3
Output:
3
Explanation:
The shortest path is as follows:
(0,0)->(0,1)->(0,2)->(0,3).
Your Task:
You don't need to read input or print anything. Your task is to complete the function shortestDistance() which takes the integer N, M, X, Y, and the 2D binary matrix A as input parameters and returns the minimum number of steps required to go from (0,0) to (X, Y).If it is impossible to go from (0,0) to (X, Y),then function returns -1. If value of the cell (0,0) is 0 (i.e  A[0][0]=0) then return -1.

Expected Time Complexity:O(N*M)
Expected Auxillary Space:O(N*M)

Constraints:
1 <= N,M <= 250
0 <= X < N
0 <= Y < M
0 <= A[i][j] <= 1
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class P20230802ShortestSourceToDestinationPath {
    public static void main(String args[]) throws IOException {
		BufferedReader read =
		new BufferedReader(new InputStreamReader(System.in));
		int N, M, x, y;
		String S[] = read.readLine().split(" ");
		N = Integer.parseInt(S[0]);
		M = Integer.parseInt(S[1]);
		int a[][] = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s[] = read.readLine().split(" ");
			for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
		}
		String s1[] = read.readLine().split(" ");
		x = Integer.parseInt(s1[0]);
		y = Integer.parseInt(s1[1]);
		Solution ob = new Solution();
		System.out.println(ob.shortestDistance(N, M, a, x, y));
    }
}
// } Driver Code Ends


// User function Template for Java

//a POJO(Plain Old Java Object) class to store i,j (row,column) coordinates of matrix A along with the distance dis
class QValue{
    int i, j, dis;
    QValue(int i, int j, int dis){
        this.i=i;
        this.j=j;
        this.dis=dis;
    }
};

class Solution {
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        // code here
        
        if(A[0][0]==0)
            return -1;
        
        //a queue that will store data of type QValue i.e. i,j coordinate of matrix A along with the distance dis.
        Queue<QValue> q = new LinkedList<>();
        
        //adding the source coordinate(0,0) along with distance
        q.add(new QValue(0,0,0));
        
        //used to calculate up/down/left/right cell in matrix.
        //look at the relative values,
        //say for first index 0f (nexti,nextj)=(row,column)=(0,1) represent same row next element i.e. right element
        //similarly (0,-1) left, (1,0) down and (-1,0) up
        int nexti[] ={0,0,1,-1}, nextj[] = {1,-1,0,0};
        
        //while queue is not empty traverse matrix for all '1' value in BFS order
        while(!q.isEmpty()){
            //retrieve the front element
            QValue temp = q.poll();
            int i=temp.i, j=temp.j, dis=temp.dis;
            
            //return if the index of the poll element matches with the mentioned co-ordinates 
            if(i==X && j==Y)
                return dis;
            
            //search for up,down,right,left element
            for(int k=0; k<4; k++){
                int newi=i+nexti[k], newj=j+nextj[k];
                
                //if newi and newj are within limits and value of new co-ordinate equals 1
                if(0<=newi && newi<N && 0<=newj && newj<M && A[newi][newj]==1){
                    //change the value to 0 and insert the cordinate with the updated distance of plus 1.
                    A[newi][newj]=0;
                    q.add(new QValue(newi,newj,dis+1));
                }
            }
        }
        
        //return -1 if the whole matrix is traverse and the mentioned X,Y coordinates is never reached.
        return -1;
    }
};