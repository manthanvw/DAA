/*
Sharath is playing a game where there are N levels. Inorder to win the game he has to reach Nth level.

The rule book explains "In one step you can either cross one level or two levels".

Return the number of distinct possible ways to win the game.

Constraints:

    1 <= N <= 45

Input Format:
-------------
Line-1: An Integer N represents number of levels.
  
Output Format:
--------------
Print an integer.


Sample Input-1:
---------------
2
  
Sample Output-1:
----------------
2

Explanation:
------------
1. 1-level+ 1-level =2
2. 2 levels in one step.
   
Sample Input-2:
---------------
4
  
Sample Output-2:
----------------
5

Explanation:
------------
1. 1-level + 1-level + 1-level + 1-level = 4
2. 1-level + 1-level + 2-levels = 4
3. 1-level + 2-levels + 1-level = 4
4. 2-levels + 1-level + 1-level = 4
5. 2-levels + 2-levels  = 4


*/
import java.util.*;
public class ClimbingStairs{
    public static int getPossibleWays(int n,int[] dp){
        if(n<=2) return n;
        if(dp[n]!=0) return dp[n];
        dp[n] = getPossibleWays(n-1,dp)+getPossibleWays(n-2,dp);
        return dp[n];
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dp[] = new int[n+1];
        System.out.print(getPossibleWays(n,dp));
        sc.close();
        
    }
}