/*Mr.Aravind is provided a list of various building heights in a city, heights[], 
which consists of all positive integers.

Mr.Aravind has two assignments. They are as follows: 
- Calculate the minimum height-minH and maximum height-maxH from heights[]. 
- Determine the highest common factor between minH and MaxH.

Your task is to help Mr.Aravind to complete his assignments and 
to return the HCF of minH and maxH.

Input Format:
-------------
Space separated integers, heights of the buildings, heights[].

Output Format:
--------------
Print an integer result, HCF of minH and maxH.


Sample Input-1:
---------------
16 8 12 24 36

Sample Output-1:
----------------
4

Explanation:
------------
minH is 8 and maxH is 36, and the HCF(8, 36) is 4


Sample Input-2:
---------------
19 23 2 5 7 9 11 13

Sample Output-2:
----------------
1

Explanation:
------------
minH is 2 and maxH is 23, and HCF(2, 23) is 1
 */

import java.util.Scanner;

public class GCD {
    static int gcd(int n1, int n2) {
        int max = Math.max(n1, n2);
        int min = Math.min(n1, n2);
        if (max % min == 0)
            return min;
        if (max % min == 1)
            return 1;
        else
            return gcd(max % min, max);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s[] = sc.nextLine().split(" ");
        int n = s.length;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(s[i]);
        int min, max;
        min = max = arr[0];
        for (int i : arr) {
            max = Math.max(i, max);
            min = Math.min(i, min);
        }
        System.out.println(gcd(min, max));
        sc.close();
    }

}