//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class P20230822MakeMatrixBeautiful {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N;
		N = Integer.parseInt(br.readLine());
		int[][] matrix = IntMatrix.input(br, N, N);
		
		Solution obj = new Solution();
		int res = obj.findMinOperation(N, matrix);
		
		System.out.println(res);
    }
}

// } Driver Code Ends



class Solution {
    public static int findMinOperation(int N, int[][] matrix) {
        // code here
        
        int count=0, max=0;
        int r[] = new int[N], c[] = new int[N];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                r[i]+=matrix[i][j];
                c[j]+=matrix[i][j];
            }
        }
        
        for(int i=0; i<N; i++){
            max=r[i]>c[i]?(r[i]>max?r[i]:max):(c[i]>max?c[i]:max);
        }
        
        for(int i=0; i<N; i++){
            count+=max-r[i];
        }
        
        
        return count;
    }
}
        
/*
Input:
3
1 2 3
4 2 3
3 2 1

Output:
6
*/