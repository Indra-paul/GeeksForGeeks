/*
Write a program to find the transpose of a square matrix of size N*N. Transpose of a matrix is obtained by changing rows to columns and columns to rows.

Example 1:

Input:
N = 4
mat[][] = {{1, 1, 1, 1},
           {2, 2, 2, 2}
           {3, 3, 3, 3}
           {4, 4, 4, 4}}
Output: 
{{1, 2, 3, 4},  
 {1, 2, 3, 4}  
 {1, 2, 3, 4}
 {1, 2, 3, 4}} 
Example 2:

Input:
N = 2
mat[][] = {{1, 2},
           {-9, -2}}
Output:
{{1, -9}, 
 {2, -2}}

Your Task:
You dont need to read input or print anything. Complete the function transpose() which takes matrix[][] and N as input parameter and finds the transpose of the input matrix. You need to do this in-place. That is you need to update the original matrix with the transpose. 

Expected Time Complexity: O(N * N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 103
-109 <= mat[i][j] <= 109
*/


//{ Driver Code Starts
//Initial Template for Java

//Driver code changed so that the code can be executed at the local machine.

import java.io.*;
import java.util.*;
import java.util.*;

class P20230710TransposeOfAMatrix
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
		int a[][] = new int[t][t];
        for(int i=0; i<t; i++){
			for(int j=0; j<t; j++){
				a[i][j]=sc.nextInt();
			}
		}
		Solution s = new Solution();
		s.transpose(t,a);
		
		for(int i=0; i<t; i++){
			for(int j=0; j<t; j++){
				System.out.print(a[i][j]+"\t");
			}
			System.out.println("");
		}
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public void transpose(int n,int a[][])
    {									//iterate over the diagonal elements and swap them.
        int swap;
        for(int i=0; i<n; i++){			//to iterate over the row.
            for(int j=i+1; j<n; j++){	//to iterate over the column.
                swap=a[i][j];
                a[i][j]=a[j][i];
                a[j][i]=swap;
            }
        }
    }
}

//NOTE: If you iterate over the complete matrix and try to swap the elements, that will result into double-swapping. So ultimately, there won't be any change in the final output. To overcome that, iterate over any one half of the matrix, upper-half of the diagonal <for(int j=i+1; j<n; j++)> or the lower half of the diagonal <for(int j=0; j<i; j++)>.