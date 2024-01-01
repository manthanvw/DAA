
/*Given an array of distinct positive integers, find the total number of
distinct permutations that add up to a given target, where each array element may be used any number of times.
input format: integer number m
              m number of integers
			  target value
output format : integer value
Example
Sample 1:
input = 4
1 2 3 4
3
output =4
Explanation: The permutations of [1, 2, 3, 4] with sum 3 are:
[1, 1, 1]
[1, 2]
[2, 1]
[3]
sample 2:
input = 3
1 3 5
5
output =5
Explanation: The permutations of [1, 3, 5] with sum 5 are:
[1, 1, 1, 1, 1]
[1, 1, 3]
[1, 3, 1]
[3, 1, 1]
[5] */
import java.util.*;

public class DistinctPermutations {
    static int ans = 0;

    public static void getCount(int arr[], int n, int target) {
        // System.out.println(target);
        if (target == 0) {
            ans++;
            return;
        }
        if (target < 0)
            return;
        for (int i : arr) {
            if (target - i >= 0) {
                getCount(arr, n, target - i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int target = sc.nextInt();
        getCount(arr, n, target);
        System.out.println(ans);
        sc.close();
    }
}
