/*In a school, 5th standard is having 2 sections called Rose and Lotus.
Section Rose contains 'm' students and Lotus contains 'n' students.
Each section students scored marks in Mathematics exam.
Teacher maintained a record of marks in ascending order of each section.
Now your task is to find out the median of the marks of 2 sections together.

Note: The overall run time complexity should be O(log (m+n)) .

Example 1:
Sample Input=4 6
32 45 70 95
40 50 59 67 73 84
Sample Output=63.0                                                        
Example 2:
Sample Input= 5 6
10 20 30 40 50
35 44 60 70 80 90
output = 44.0


Example 3:
Input 3:4 6
3 6 8 10
14 17 20 33 44 55
Output:15.5
*/

import java.util.Scanner;

public class MedianSortedArrays {
    static double getMedian(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        if (n > m) return getMedian(B, A);

        int start = 0;
        int end = n;
        int k = (n + m + 1) / 2;

        while (start <= end) {
            int mid = (start + end) / 2;
            int leftA = (mid > 0) ? A[mid - 1] : Integer.MIN_VALUE;
            int leftB = (k - mid > 0) ? B[k - mid - 1] : Integer.MIN_VALUE;
            int rightA = (mid < n) ? A[mid] : Integer.MAX_VALUE;
            int rightB = (k - mid < m) ? B[k - mid] : Integer.MAX_VALUE;

            if (leftA <= rightB && leftB <= rightA) {
                if ((m + n) % 2 == 0) return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
                return Math.max(leftA, leftB);
            } else if (leftA > rightB) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return 0.0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] nums1 = new int[m];
        int[] nums2 = new int[n];
        for (int i=0; i<m;i++) nums1[i] = sc.nextInt(); 
        for (int i=0; i<n;i++) nums2[i] = sc.nextInt(); 
        double median = getMedian(nums1,nums2);
        System.out.println(median);
        sc.close();
    }
}
