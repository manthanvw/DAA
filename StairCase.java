/*Mason work is going on at your home, and presently mason is building staircase. 
The stair case consists of k rows, where the ith row has exactly i bricks.
The last row of the staircase may be incomplete.

you have n bricks and can you give the number of complete rows of the staircase mason will build.

Solve this problem in  O(logn) time complexity.

input format : an integer number
outpu format : an integer numebr

Example 1:
input= 5
output =2
Explanation :(Here B stands for brick)
B1
B2 B3
B4 B5
first row constructed with 1 brick row =1 no.of bricks =1
second row constructed with 2 bricks row=2 no.of bricks = 2
third row constructed with 2 bricks  row =3 no.of bricks =2 (incomplete row)
as third row is incomplete we are returing 2 as answer.

Example :2
input =10
output =4
Explanation:
B1
B2 B3
B4 B5 B6
B7 B8 B9 B10
all rows are completed so return 4

Example :3
input = 19
output =5*/

import java.util.Scanner;

public class StairCase {
     static int getRows(int n){
        int l = 1;
        int h = n;
        int mid=0;
        while(l<=h){
            mid = l+(h-l)/2;
            int count = mid*(mid+1)/2;
            if(count==n) return mid;
            else if(count<n) l = mid+1; 
            else h=mid-1;
        }
        return h;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getRows(n));
        sc.close();
    }
}
