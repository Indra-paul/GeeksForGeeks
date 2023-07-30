/*

*/


//{ Driver Code Starts
//Initial Template for Java

//Driver code changed so that the code can be executed at the local machine.

import java.io.*;
import java.util.*;
import java.util.*;

class P20230711FindKthElementOfSpiralMatrix
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int m=sc.nextInt();
		int n=sc.nextInt();
		int k=sc.nextInt();
		int a[][] = new int[m][n];
        for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				a[i][j]=sc.nextInt();
			}
		}
		Solution s = new Solution();
		System.out.println(s.findK(a,m,n,k));
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    /*You are required to complete this method*/
    int findK(int A[][], int n, int m, int k)
    {
	// Your code here
	int top=0, bottom=n-1, left=0, right=m-1, direction=0, count;
	
	while(top<=bottom && left<=right && k>=0){
	    
	    if(direction==0){
	        count=right-left+1;
	        if(count<=k){
	            k-=count;
	            if(k==0)
	                return A[top][right];
	        }
	        else{
	            int i;
	            for(i=left; i<right; i++){
	                if(--k == 0)
	                    break;
	            }
	            return A[top][i];
	        }
	        top++;
	        //System.out.println("Direction "+direction+" ends: "+top+" "+right+" "+bottom+" "+left+" "+k);
	        
	    } else if(direction==1){
	        count=bottom-top+1;
	        if(count<=k){
	            k-=count;
	            if(k==0)
	                return A[bottom][right];
	        }
	        else{
	            int i;
	            for(i=top; i<bottom; i++){
	                if(--k == 0)
	                    break;
	            }
	            return A[i][right];
	        }
	        right--;
	        //System.out.println("Direction "+direction+" ends: "+top+" "+right+" "+bottom+" "+left+" "+k);
	    } else if(direction==2){
	        count=right-left+1;
	        if(count<=k){
	            k-=count;
	            if(k==0)
	                return A[bottom][left];
	        }
	        else{
	            int i;
	            for(i=right; i>left; i--){
	                if(--k ==0)
	                    break;
	            }
	            return A[bottom][i];
	        }
	        
	        bottom--;
	        //System.out.println("Direction "+direction+" ends: "+top+" "+right+" "+bottom+" "+left+" "+k);
	    }
	    else{
	        count=bottom-top+1;
	        if(count<=k){
	            k-=count;
	            if(k==0)
	                return A[top][left];
	        }
	        else{
	            int i;
	            for(i=bottom; i>top; i--){
	                if(--k ==0)
	                    break;
	            }
	            return A[i][left];
	        }
	        
	        left++;
	        //System.out.println("Direction "+direction+" ends: "+top+" "+right+" "+bottom+" "+left+" "+k);
	    }
	    
	    direction = (direction+1) % 4;
	}//while loop ends
	return 99999;
    }//findK() methods ends
}