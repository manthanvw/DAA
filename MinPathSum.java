/*Find minimum path sum in a triangle shaped matrix

Given a right-angled triangle-shaped matrix, find the shortest path sum from the top
element to any element in the last row of the matrix.

We can only move down from the present cell at any given time. 
Hence, the legal movements from cell (x,y) are either (x+1,y) or (x+1,y+1). For example, 

input format: integer number m number of rows 
              integer numbers m number of rows enter one integer in first row, 
			  two integers in second row, three integers in third row and m number of integers in last row
output format : intger number

example :
case =1
input =
4
4
1 3
1 2 1
8 4 5 1
output =9

Explanation
[4]                         [9, 0, 0, 0]
[1, 3]						[6, 5, 0, 0]
[1, 2, 1]                   [5, 6, 2, 0]
[8, 4, 5, 1]                [8, 4, 5, 1]

case =2
input =5
1
1 2
1 2 3
1 2 3 4
1 2 3 4 5
output =5 */

import java.util.*;

public class MinPathSum {
    public static int getMinPathSum(int grid[][], int n, int cost, int i, int j, int dp[][]) {
        if (i >= n)
            return cost;
        // if(dp[i][j]!=0) return dp[i][j];
        return Math.min(
                getMinPathSum(grid, n, cost + grid[i][j], i + 1, j, dp),
                getMinPathSum(grid, n, cost + grid[i][j], i + 1, j + 1, dp));
        // return dp[i][j];

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int grid[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int dp[][] = new int[n][n];
        System.out.println(getMinPathSum(grid, n, 0, 0, 0, dp));
        sc.close();
    }
}