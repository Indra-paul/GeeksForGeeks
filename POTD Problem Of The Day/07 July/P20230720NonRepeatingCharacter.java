//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class P20230720NonRepeatingCharacter
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
		String st = sc.next();
		
		char ans=new Solution().nonrepeatingCharacter(st);
		
		if(ans!='$')
		System.out.println(ans);
		else
		System.out.println(-1);
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the first non-repeating character in a string.
    static char nonrepeatingCharacter(String S)
    {
        //Your code here
        char ch[] = S.toCharArray();
        Character c;
        int len=S.length();
        List<Character> un = new ArrayList<>();
        List<Character> dup = new ArrayList<>();
        
        for(int i=0; i<len; i++){
            c=ch[i];
            if(dup.contains(c))
                continue;
            else if(un.contains(c)){
                un.remove(c);
                dup.add(c);
            }
            else
                un.add(c);
        }
        
        if(un.size()>0)
            return un.get(0);
        else
            return '$';
    }
}

