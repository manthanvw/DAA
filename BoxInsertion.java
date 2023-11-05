/*Mr.Balu is working in a metal store he has to arrange the steel boxes for saving 
space he used to insert one box into another,Every day he used to get different sized boxes,
help him to make his work simple by writing a program to find maximum number of boxes
he can put one inside the other. 

For this, You are given a 2D array of integers boxes where boxes[i] = [wi, hi] represents 
the width and the height of a box.
One box can fit into another if and only if both the width and height of one box are 
greater than the other box's width and height.
Return the maximum number of boxes you can  put one inside the other.

Note: Consider only width and height of boxes.
input format : integer number n
               n number of pairs
output format : an integer n 
Example 1:
Input: 4
5 4
6 4
6 7
2 3
Output: 3
Explanation: The maximum number of boxes you can insert is 3 ([2,3] => [5,4] => [6,7]).

Example 2:
Input: 3
1 1 
1 1
1 1
Output: 1

Example 3:
Input: 5
2 3
6 4
6 7
2 4
8 9
Output: 1
*/

import java.util.Arrays;
import java.util.Scanner;

public class BoxInsertion {
        public static int maxBoxes(int[][] boxes) {
        int n = boxes.length;
        Arrays.sort(boxes, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int[] dp = new int[n];
        int maxBoxes = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (boxes[i][0] > boxes[j][0] && boxes[i][1] > boxes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxBoxes = Math.max(maxBoxes, dp[i]);
        }

        return maxBoxes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] boxes = new int[n][2];

        for (int i = 0; i < n; i++) {
            boxes[i][0] = sc.nextInt();
            boxes[i][1] = sc.nextInt();
        }

        int result = maxBoxes(boxes);
        System.out.println(result);
        sc.close();
    }

}
