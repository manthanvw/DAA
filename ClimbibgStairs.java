/*Given a staircase of N steps and you can either climb 1 or 2 steps at a 
given time. The task is to return the count of 
distinct ways to climb to the top.
Note: The order of the steps taken matters.
Test Case1:
Input: 3
Output: 3
Explanation:
There are three distinct ways of climbing a staircase of 3 steps :
[1, 1, 1], [2, 1] and [1, 2].

Test Case2:
Input:  2
Output: 2

Explanation:
There are two distinct ways of climbing a staircase of 2 steps :
[1, 1] and [2].

Test Case3:
Input: 4
Output: 5
Explanation:
There are Five distinct ways of climbing a staircase of 4 steps :
(1, 1, 1, 1), (1, 1, 2), (2, 1, 1), (1, 2, 1), (2, 2)
*/

import java.util.Scanner;

public class ClimbibgStairs {
    static int fib(int n){
        if(n==1){
            return 1;
        }
        else if(n==2){
            return 2;
        }
        else{
            int ans = fib(n-2)+fib(n-1);
            return ans;
        }
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(fib(n)+" ");
        sc.close();
    }
}
