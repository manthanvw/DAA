/*Bob Marley is a jamaican singer, he loves to travel around the globe.
He planned to travel N famous places and return to the starting station.
Each place is indicated with numbers from 0 to N-1.
He will start the travel from Place-0.
 
You are given an integer N and cost matrix cost[][],a symmetric matrix, 
where cost[i][j] indicates cost to travel from place-i to place-j and vice-versa, 
if cost[i][j]=0, indicates no way to travel from place-i to place-j and vice-versa. 

Your task is to help Bob Marley, to find the shortest possible travel plan
to visit every place and returns to starting place-0. 
Finally print the minimum cost to travel accordingly.

Input Format:
-------------
Line-1: An integer N. 
Next N lines: N space separated integers, cost of i to j.

Output Format:
--------------
Print an integer, the minimum cost to travel all the places and return to place-0.


Sample input -1
3
0 15 10 
12 0 12 
8 14 0

Sample output-1

35

Sample Input-2:
---------------
5
0 15 5 12 15
15 0 7 13 9
5 7 0 10 15
12 13 10 0 7
15 9 15 7 0

Sample Output-2:
----------------
40 */
import java.util.*;
public class TravellingSalesmanDP {
    public static int tsp(int grid[][],int n,boolean visited[],int cur,int count,int cost,int ans){
        int min = Integer.MAX_VALUE;
        if(count==n && grid[cur][0]>0){
            ans = Math.min(ans,cost+grid[cur][0]);
            return ans;
        }
        for (int i=0; i<n;i++){
            if((!visited[i]) && grid[cur][i]>0 && cur!=i){
                visited[i] = true;
                min = Math.min(min,tsp(grid,n,visited,i,count+1,cost+grid[cur][i],ans));
                visited[i] = false;
            }
        } 
        return min;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int grid[][] = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                grid[i][j] = sc.nextInt();
            }
        }
        boolean visited[] = new boolean[n];
        visited[0] = true;
        System.out.println(tsp(grid,n,visited,0,1,0,Integer.MAX_VALUE));
        sc.close();
    }
}