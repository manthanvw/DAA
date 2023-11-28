/*
Viraj Aanand is a wedding planner, He order his assistant to decorate a wall.
The decorator plans to decorate the wall with two different colored balloons.
The wall size is M*N, The decorator can decorate the wall using M*N balloons
the balloons are blue or white in color.

Blue colored ballons represented with digit-1 and 
White colored ballons represented with digit-0.

The blue colored balloons forms different shapes, that are connected 4 directonally.
The directons are upwards, downwards, left, and right. Viraj Aanand got an idea to 
count the unique shapes formed by blue colored ballons.

You will be given the decorated wall as a matrix wall[][].
Your task is to help, Viraj Aanand to count the unique shapes.

Input Format:
-------------
Line-1: Two space separated integers M and N, size of the wall.
Next M lines: N space separated integers, either 0 or 1.

Output Format:
--------------
Print an integer, Number ofa distinct shapes formed by blue balloons.


Sample Input-1:
---------------
4 5
1 1 0 0 0
1 1 0 0 0
0 0 0 1 1
0 0 0 1 1

Sample Output-1:
----------------
1


Sample Input-2:
---------------
5 5
1 1 0 1 1
1 0 0 0 1
0 0 0 0 0
1 0 0 0 1
1 1 0 1 1

Sample Output-2:
----------------
4

Note: 
-------
The shapes, 
1 1  		  1 1
1     and    1 
are different.
*/
import java.util.*;

public class DistinctIsland {
    private static int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int numDistinctIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Set<List<List<Integer>>> islands = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                List<List<Integer>> island = new ArrayList<>();

                if (bfs(i, j, grid, m, n, island))
                    islands.add(island);
            }
        }

        return islands.size();
    }

    private boolean bfs(int i, int j, int[][] grid, int m, int n, List<List<Integer>> island) {
        if (i < 0 || m <= i || j < 0 || n <= j || grid[i][j] <= 0) return false;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        grid[i][j] *= -1;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int row = pos[0], col = pos[1];

            island.add(Arrays.asList(row - i, col - j));

            for (int d = 0; d < 4; d++) {
                int newRow = row + delta[d][0];
                int newCol = col + delta[d][1];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] > 0) {
                    queue.offer(new int[]{newRow, newCol});
                    grid[newRow][newCol] *= -1;
                }
            }
        }
        return true;
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int R = scan.nextInt();
        int C = scan.nextInt();
        DistinctIsland di = new DistinctIsland();
        int[][] field = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                field[i][j] = scan.nextInt();
            }
        }
        System.out.println(di.numDistinctIslands(field));
        scan.close();
    }
}

