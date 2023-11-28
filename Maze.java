/*
You are entering into a maze N*N grid consist of(0's and 1's)
Initially you will start from (0,0) position in the maze, 
Your target is to reach the end position (N-1, N-1).

Among the four directions available(top, down, left, right),
you can move in two directions only, right and down.

In the maze, '0' indicates dead end and '1' indicates open way. 
You can travel through only open way.

For Example:-
Given Maze of size N=4 , starting position is (0, 0),
1 0 0 0
1 1 0 1
0 1 0 0
1 1 1 1

You can reach the (3, 3) position in the following way.
1 0 0 0
1 1 0 0
0 1 0 0
0 1 1 1

Return true, if you can reach the end position(N-1, N-1).
otherwise return false.

Input Format:
-------------
Line-1 -> An integer N, size of square board.
Next N lines -> N space separated integers 

Output Format:
--------------
Print a boolean value.

Sample Input-1:
---------------
4
1 0 0 0
1 1 0 1
0 1 0 0
1 1 1 1

Sample Output-1:
----------------
true


Sample Input-2:
---------------
4
1 1 0 0
1 0 0 1
0 1 1 0
1 0 0 1

Sample Output-2:
----------------
false*/
import java.util.Scanner;

public class Maze 
{ 
	private int size; 
	Maze(int N)
	{
		this.size = N;
	}
	
	boolean isSafe( int maze[][], int x, int y) 
	{ 
        if(x>=0 && x<size && y>=0 && y<size && maze[x][y]==1)
            return true;
        return false;
	} 
	
	boolean solveMaze(int maze[][]) 
	{ 
	    if(maze[size-1][size-1] == 0) return false;
        return dfs(maze,0,0);    
	
	} 
	
	boolean dfs(int maze[][], int x, int y) 
	{ 
	    if (x == size - 1 && y == size - 1) {
            return true;
	    }

        if (isSafe(maze, x, y)) {
            if (dfs(maze, x, y + 1)) {
                return true;
            }
            if (dfs(maze, x + 1, y)) {
                return true;
            }
        }

        return false;
	} 

	public static void main(String args[]) 
	{ 
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Maze m = new Maze(n); 
		int maze[][] = new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				maze[i][j]=sc.nextInt();
		System.out.println(m.solveMaze(maze)); 
		sc.close();
	} 
} 