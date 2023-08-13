/*
Geek has N bricks. He needs to build a staircase consisting of k rows where the ith row has exactly i bricks. If he starts from the first row, find the number of complete rows of the staircase that he will be able to build completely.

Example 1:

Input:
N: 5
Output: 2
Explanation: 
Row 1: X
Row 2: X X
Row 3: X X
Only 2 rows are complete.

Example 2:

Input:
N: 8
Output: 3
Explanation:
X
X X
X X X
X X
Only 3 rows are complete.

Your Task:
You dont need to read input or print anything. Your task is to complete the function completeRows() which takes integer n as input parameter and returns the number of complete rows possible.


Constraints:
1 <= n <= 109
*/

//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class WCC115CompleteTheStaircase {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Solution ob = new Solution();
		int ans = ob.completeRows(n);
		
		System.out.println(ans);	
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution {
	
	//FUNCTION LOGIC
	/*
		ith row contains i number of blocks
		So, total block required to completely fill ith row is (i*(i+1))/2 i.e. summation of i natural numbers
		So the above should be less than or equal to provided number of blocks n
		Balancing the equation
			i*(i+1) <= 2n
			
		That means, we require two consecutive numbers whose multiplication is less than or equal to 2n.
		But we don't have any in-built function that gives us the required numbers.
		
		Alternatively, we can use square root function which will give us the number near that.
		Let's denote the output of Math.sqrt() as num of type int.
		
		suppose for n=13, num will be 4, 4*5 = 20 < 2n = 26. Therefore answer will be num i.e. 4
		But for for n=9, num will still be 4, 4*5 20 !< 2n = 18. Therefore answer will be num-1 i.e. 3
	*/
	
    public int completeRows(int n) {
        //Your code here
        int num=(int)Math.sqrt(2*n);
        return (num*(num+1))<=2*n?num:num-1;
        
    }

   

}