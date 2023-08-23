/*
Given a 2D grid of n*m of characters and a word, find all occurrences of given word in grid. A word can be matched in all 8 directions at any point. Word is said to be found in a direction if all characters match in this direction (not in zig-zag form). The 8 directions are, horizontally left, horizontally right, vertically up, vertically down, and 4 diagonal directions.

Note: The returning list should be lexicographically smallest. If the word can be found in multiple directions starting from the same coordinates, the list should contain the coordinates only once. 

Example 1:

Input: 
grid = {{a,b,c},{d,r,f},{g,h,i}},
word = "abc"
Output: 
{{0,0}}
Explanation: 
From (0,0) we can find "abc" in horizontally right direction.
Example 2:

Input: 
grid = {{a,b,a,b},{a,b,e,b},{e,b,e,b}}
word = "abe"
Output: 
{{0,0},{0,2},{1,0}}
Explanation: 
From (0,0) we can find "abe" in right-down diagonal. 
From (0,2) we can find "abe" in left-down diagonal. 
From (1,0) we can find "abe" in horizontally right direction.
Your Task:
You don't need to read or print anything, Your task is to complete the function searchWord() which takes grid and word as input parameters and returns a list containing the positions from where the word originates in any direction. If there is no such position then returns an empty list.

Expected Time Complexity: O(n*m*k) where k is constant
Expected Space Complexity: O(1)

Constraints:
1 <= n <= m <= 50
1 <= |word| <= 15
*/


//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class P20230823FindTheStringInGrid
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s1 = br.readLine().trim().split(" ");
		int n = Integer.parseInt(s1[0]);
		int m = Integer.parseInt(s1[1]);
		char[][] grid = new char[n][m];
		for(int i = 0; i < n; i++){
			String S = br.readLine().trim();
			for(int j = 0; j < m; j++){
				grid[i][j] = S.charAt(j);
			}
		}
		String word = br.readLine().trim();
		Solution obj = new Solution();
		int[][] ans = obj.searchWord(grid, word);
		for(int i = 0; i < ans.length; i++){
			for(int j = 0; j < ans[i].length; j++){
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
		if(ans.length==0)
		{
			System.out.println("-1");
		}
    }
}

// } Driver Code Ends


class Solution
{
    static int xrow[] = {-1,-1,-1,0,0,1,1,1};
    static int xcol[] = {-1,0,1,-1,1,-1,0,1};
    
    public int[][] searchWord(char[][] grid, String word)
    {
        // Code here
        int lrow=grid.length, lcol=grid[0].length;
        char[] ch=word.toCharArray();
        ArrayList<Integer[]> arr = new ArrayList<>();
        
		//if the word is of length 1
        if(ch.length==1){
            for(int i=0; i<lrow; i++){
                for(int j=0; j<lcol; j++){
					//compare the character value with every grid[][] index
                    if(ch[0]==grid[i][j]){
						//and store the index i and j if it matches
                        Integer[] x = new Integer[2];
                        x[0]=i;
                        x[1]=j;
                        arr.add(x);
                    }
                }
            }
        }
        else{
            for(int i=0; i<lrow; i++){
                for(int j=0; j<lcol; j++){
					//if the first character of ch matches with the current grid[][] 
                    if(grid[i][j]==ch[0]){
						//compare all the 8 direction w.r.t. to the current index
                        for(int k=0; k<8; k++){
							//calculating the new index
                            int nrow=i+xrow[k];
                            int ncol=j+xcol[k];
							//checking if the new index is within the range of grid
							//also chekcing if the second character i.e. ch[1] equals to new index value in grid[][]
                            if( (nrow>=0 && nrow<lrow) && (ncol>=0 && ncol<lcol) && (ch[1]==grid[nrow][ncol])){
								//if the above condition is matched, a mthod is called to check if there is the word present in any of the 8 direction.
                                if(wordMatch(grid,ch,k,lrow,lcol,nrow,ncol)){
                                    //System.out.println(i+" "+j);
									//storing the index i and j in and Integer[]
                                    Integer[] x = new Integer[2];
                                    x[0]=i;
                                    x[1]=j;
									//adding the Integer array x in the ArrayList arr
                                    arr.add(x);
									//breaking from the k loop if a word is found in any of the direction
                                    break;
                                }
                            }
                        } 
                    }
                    
                }
            }
        }
        
		//converting ArrayList to 2-D array
        int[][] y = new int[arr.size()][2];
        for(int i=0; i<arr.size(); i++){
            Integer[] x = arr.get(i);
            y[i][0] = x[0];
            y[i][1] = x[1];
        }
        
		//returning the 2-D array
        return y;
    }
    
    public static boolean wordMatch(char[][] grid, char[] ch, int k, int lrow, int lcol, int i, int j){
        //calculating final row and column index in matrix w.r.t. current index i, j and character ch length
		//reducing 2 from ch length as we have already considered ch[0] and ch[1] in the main method
		int finRowIndex=i+(ch.length-2)*xrow[k];
        int finColIndex=j+(ch.length-2)*xcol[k];
		
		//returning false in case final index of row and column is out of matrix bound
        if(!(finRowIndex<lrow && finRowIndex>=0 && finColIndex<lcol && finColIndex>=0))
            return false;
		
		//initializing ni and nj with i and j respectively. though we can overwrite value of i and j, but not advisable.
		//example of clean code where passed arguement value is not modified in the method.
        int ni=i, nj=j;
        for(int a=2; a<ch.length; a++){
			//adding the same xrow[k] and xcol[k] in ni and nj.
			//this ensures that we are travelling in the same direction and not zig-zag.
            ni+=xrow[k];
            nj+=xcol[k];
			//if any of the character value doesn't matches with the grid[][] value, return false;
            if(ch[a]!=grid[ni][nj])
                return false;
        }
		//returning true is none of the above condition is met in which case the function would have returned false.
        return true;
    }
}


/*
Input 1:
3 3
abc
def
ghi
abc

Output:
0 0


Input 2:
5 5
ccccc
cbbbc
cbabc
cbbbc
ccccc
abc

Output:
2 2

Input 3:
10 14
ljkjiiliikilkm
iljljkijmlmkji
lmikimkkimkiii
kjlmmjiimjjjlk
llmllkjijmkklj
ijkiikijkkljkm
mljiklilikliki
lijmiimmmkllil
ikljkkiiijjlkk
ikmiljkljikjlj
kkll

Output:
5 8
6 12

Input 4:
4 13
ddebacdbdcecb
ccccccaecbeab
beeedbcdcadbc
dacaaaeaebdcd
dd


Output:
0 0
0 1
2 10
3 10

*/