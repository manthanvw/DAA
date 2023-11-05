/*You are given a positive integer, you have to find that is 
perfect square or not. With your programming skills write a program to do 
this task in O(log(n)) time. And don't use built in library functions. 
Use binary search algorithm to do this task.

Input format : an integer number n
output format : true or false

Example 1:
Input : 25
output : true

Example 2:
Input : 9
output : true

Example 3:
Input :8
output :false

Example 4:
Input : 125
output : false
*/

import java.util.Scanner;

public class PerfeSquare {
    static int isPS(int l,int r,int n){
        int mid = (l+r)/2;
        long sq = mid*mid;
        if(l<=r){
            if(sq==n) return 1;
            else if(sq<n) return isPS(mid+1,r,n);
            else return isPS(l,mid-1,n);
        }
        return -1; 
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = isPS(0,n,n);
        if(ans != -1) System.out.println(true);
        else System.out.println(false);
        sc.close();
    }
}
