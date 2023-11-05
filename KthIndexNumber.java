/* We  build a table of n rows (1-indexed). We start by writing 0 in the 1st row. 
Now in every subsequent row, we look at the previous row and replace 
each occurrence of 0 with 01, and each occurrence of 1 with 10.

For example, for n = 3,
the 1st row is 0, 
the 2nd row is 01, 
and the 3rd row is 0110.
your task is, Given two integer n and k, return the kth (1-indexed) symbol 
in the nth row of a table of n rows.
input format : two integers n and k
output fromat:  0 or 1
note : k <= n
Example 1:

Input: n = 1, k = 1
Output: 0
Explanation: row 1: 0

Example 2:

Input: n = 2, k = 1
Output: 0
Explanation: 
row 1: 0
row 2: 01
Example 3:

Input: n = 2, k = 2
Output: 1
Explanation: 
row 1: 0
row 2: 01
 

Constraints:

1 <= n <= 30
1 <= k <= 2n - 1 */

import java.util.Scanner;

public class KthIndexNumber {
    static char getVal(int n,int k){
        String s = helper(n,k);
        return s.charAt(k-1);
    }
    
    static String helper(int n,int k){
        if(n==0) return "0";
        else{
            String ans = helper(n-1,k);
            int l=ans.length();
            for(int i=0;i<l;i++){
                if(i==k) return ans;
                int a = Integer.parseInt(ans.charAt(i)+"");
                if(a==0) a=1;
                else a=0;
                ans+= Integer.toString(a);
            }
            return ans; 
        }
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(getVal(n,k));
        sc.close();
    }
}
