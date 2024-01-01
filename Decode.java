/*
Given a positive number, map its digits to the corresponding alphabet in the 
mapping table [(1, 'A'), (2, 'B'),(26, 'Z')], and return the count of the total 
number of decodings possible. Assume that the input number can be split into 
valid single-digit or two-digit numbers that are present in the mapping table.
A single-digit between 1 to 9 can be mapped to a corresponding alphabet 
between A to I.
Two digits between 10 to 26 can be mapped to a corresponding alphabet 
between J to Z.
input format: an intger number 
output format : an integer number
Example
Input:  123
Output: 3
Explanation : with 123 combination we can form 
[ABC(123), AW(A=1,W=23), LC(L=12 and C=3)]
Input:  1221
Output: 5
Explanation :with 1221 combination we can form [ABBA, ABU, AVA, LBA, LU]
*/

import java.util.*;


public class Decode {
    // Function to count the total decodings of a given sequence of digits
    public static int getCount(char[] chars, int n, int[] dp) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int total = 0;
    
        if (chars[n - 1] > '0') {
            total = getCount(chars, n - 1, dp);
        }
        if (chars[n - 2] == '1' || (chars[n - 2] == '2' && chars[n - 1] <= '6')) {
            total += getCount(chars, n - 2, dp);
        }
        dp[n] = total;
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        char[] chars = String.valueOf(x).toCharArray();
        int[] dp = new int[chars.length + 1];
        Arrays.fill(dp, -1);
        System.out.println(getCount(chars, chars.length, dp));
        sc.close();
    }
}