/*
Given n, check if it is a beautiful number or not. 
You will have to follow a process to determine if a number is beautiful or not:

Starting with the given number (guaranteed to be an integer), replace the number by the sum of the squares of its digits.
The process continues until the number equals 1, or it loops endlessly in a cycle which does not include 1.
Numbers for which this process ends in 1 are considered beautiful.

Example 1:

Input:
n = 19
Output: 
1
Explanation: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
12 = 1
Example 2:

Input:
n = 2
Output: 
0
Explanation: 
22 = 4
42 = 16
12 + 62 = 37
32 + 72 = 58
52 + 82 = 89
82 + 92 = 145
12 + 42 + 52 = 42
42 + 22 = 20
22 + 02 = 4
The cycle will repeat after 4, and will never reach 1.
Your Task:

You don't need to read input or print anything. Your task is to complete the function beautifulNumber() which takes integer n as input parameter and returns a boolean value 1 if n is beautiful, otherwise 0.

Constraints: 
1 <= N <= 109
*/

//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class WCC114BeautifulNumber {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Solution ob = new Solution();
		boolean ans = ob.beautifulNumber(n);
		if(ans){
			 System.out.println("Yes");
		}else{
			 System.out.println("No");
		}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean beautifulNumber(int n) {
        // Your code here
        
        Set<Integer> hashSet = new HashSet<>();
        
        while(n!=1){
            n=unitSquareSum(n);
            if(hashSet.contains(n))
                return false;
            
            hashSet.add(n);
        }
        return true;
    }
    
    public static int unitSquareSum(int n){
        int sum=0, unit;
        while(n>0){
            unit=n%10;
            sum+=unit*unit;
            n/=10;
        }
        return sum;
    }
}