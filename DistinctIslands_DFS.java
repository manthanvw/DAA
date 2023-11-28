/*
Pranav has a puzzle board filled with square boxes in the form of a grid.
Some cells in the grid may be empty. '0' - indicates empty, '1' - indicates a box. 

The puzzle board has some patterns formed with boxes in it, 
the patterns may be repeated. The patterns are formed with boxes (1's) only, 
that are connected horizontally and vertically but not diagonally.

Pranav wants to find out the number of unique patterns in the board.

You are given the board in the form of a grid M*N, filled wth 0's and 1's.
Your task is to help Pranav to find the number of unique patterns in the puzzle board.

Input Format:
-------------
Line-1: Two integers M and N, the number of rows and columns in the grid-land.
Next M lines: contains N space-separated characters ['0','1'].

Output Format:
--------------
Print an integer, the number of unique patterns in the puzzle board.


Sample Input-1:
---------------
5 5
0 1 0 1 1
1 1 1 0 1
0 1 0 1 0
1 0 1 1 1
1 1 0 1 0

Sample Output-1:
----------------
3

Explanation-1:
------------
The unique patterns are as follows:
  1			 1 1		1 
1 1 1		   1  	,	1 1
  1		,	
   
   
Sample Input-2:
---------------
6 6
1 1 0 0 1 1
1 0 1 1 0 1
0 1 0 1 0 0
1 1 0 0 0 1
0 0 1 0 1 1
1 1 0 1 0 0

Sample Output-2:
----------------
5

Explanation-2:
------------
The unique patterns are as follows:
1 1		1 1		    1			1 1 	1
1   	  1         1 1 			
*/

import java.util.*;

public class DistinctIslands_DFS {
    // private static int[][] delta = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

    public int numDistinctIslands(int[][] grid) 
    {
        
        /*Write code here*/
		return 1;
        
    }

    // private boolean dfs(int i0, int j0, int i, int j, int[][] grid, int m, 
    // int n, List<List<Integer>> island) 
    // {
        
    //     /*Write code here*/
    //     return true;
    // }

	public static void main(String args[] ) 
	{
		Scanner scan = new Scanner(System.in);
		int R=scan.nextInt();
		int C=scan.nextInt();      
		DistinctIslands_DFS di=new DistinctIslands_DFS();
		int[][] field=new int[R][C];
	   for(int i=0; i<R; i++)
	   {
		   for(int j=0; j<C; j++)
		   {
			   field[i][j] = scan.nextInt();
		   }
	   }
	   System.out.println(di.numDistinctIslands(field));
	   scan.close();
	}
}