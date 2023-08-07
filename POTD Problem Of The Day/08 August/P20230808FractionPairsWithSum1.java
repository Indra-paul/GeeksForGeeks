/*
Given a list of N fractions, represented as two lists numerator and denominator, the task is to determine the count of pairs of fractions whose sum equals 1.

Example 1:

Input:
N = 4
numerator = [1, 2, 2, 8]
denominator = [2, 4, 6, 12]
Output:
2
Explanation:
Fractions 1/2 and 2/4 sum to 1. Similarly fractions 2/6 and 8/12 sum to 1. So there are 2 pairs of fractions which sum to 1.
Example 2:

Input:
N = 5
numerator = [3, 1, 12, 81, 2]
denominator = [9, 10, 18, 90, 5]
Output:
2
Explanation:
Fractions 3/9 and 12/18 sum to 1. Similarly fractions 1/10 and 81/90 sum to 1. So there are 2 pairs of fractions which sum to 1.
Your task:
You don't need to read input or print anything. Your task is to complete the function countFractions() which take integer N and arrays numerator and denominator of size N as arguments, and returns an integer.

Expected Time Complexity: O(N*log(N))
Expected Auxiliary Space: O(N)

Constraints:
1 <= N <=105
1 <= numerator[i] <= denominator[i] <= 109
*/


//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class P20230808FractionPairsWithSum1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
		int n;
		n = Integer.parseInt(br.readLine());
		
		int[] numerator = IntArray.input(br, n);
		
		int[] denominator = IntArray.input(br, n);
		
		Solution obj = new Solution();
		int res = obj.countFractions(n, numerator, denominator);
		
		System.out.println(res);
    }
}

// } Driver Code Ends



class Solution {
    public static int countFractions(int n, int[] num, int[] den) {
        // code here
        
        int ans = 0;
        Map<Long, Integer> fractionCount = new HashMap<>();

        //initializing the required variable for the program
        long gcd, reducedNumerator, reducedDenominator, fractionKey, complementaryNumerator;

        for (int i = 0; i < n; i++) {
            
            //calculate gcd/hcf of numerator and denominator
            gcd = gcd(num[i], den[i]);
            
            //factorize the numerator and denominator
            reducedNumerator = num[i] / gcd;
            reducedDenominator = den[i] / gcd;
            
            //we need to store both the numerator and denominator value
            //as the input array can contain values with multiple numerator or denominator.
            //so to track all the numerator and denominator values,
            //left shift numberator to 32bits (4bytes i.e. size of int)
            //and do logical bitwise operation with denominator
            //size of key(long) = 8bytes = 64 bits = numerator (int, 32 bits) + denominator (int, 32 bits)
            fractionKey = (reducedNumerator << 32) | reducedDenominator;
            
            //it is the numerator which we will be searching in the map.
            //since sum of pair needs to be 1, complementaryNumerator will be denominator minus numerator.
            complementaryNumerator = reducedDenominator - reducedNumerator;
            //long complementaryDenominator = reducedDenominator;

            //if Map contains the Key, return the corresponding value
            //similarly performing the left shift operation with complementaryNumerator
            //and logically bitwising with denominator
            if (fractionCount.containsKey(complementaryNumerator << 32 | reducedDenominator)) {
                ans += fractionCount.get(complementaryNumerator << 32 | reducedDenominator);
            }

            //getOrDefault method returns the value if key is present, else returns the provided default value
            //put the key i.e. fractionKey and an increment of value by 1 in the Map
            fractionCount.put(fractionKey, fractionCount.getOrDefault(fractionKey, 0) + 1);
        }

        //return the count of (numeraotr,denominator) pairs with sum equal to 1
        return ans;
        
    }
    
    
    //function to calculate the gcd/hcf of two numbers
    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}


/*
Custom Input
4
1 2 2 8
2 4 6 12
Output
2
*/