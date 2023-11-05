/*There is a survey taking place in a city with the aim of identifying 
special houses known as 'peaks,' where a house stands higher than its 
neighboring ones. Can you assist the surveyor by writing a program that takes 
the heights of houses as an array and prints the heights of the peak houses 
in a sorted list?

input : an integer n 
        n number of distinct integers
output : list of integers in sorted order

Example 1:
input = 8
9 4 5 3 8 7 10 11
output =[5, 8, 9, 11]
Example 2:
input = 10
1 2 3 4 5 6 7 8 9 10
output=[10]
Example 3:
input =10
10 9 8 7 6 5 4 3 2 1
output=[10]
Example 4:
input = 10
1 2 3 4 5 10 6 7 8 9
output = [9, 10]
*/

import java.util.Arrays;
import java.util.Scanner;

public class PeakElementsList {
    static int[] getPeak(int nums[],int n){
        int ans[] = new int[n];
        int i=0;
        if(nums[0]>nums[1]){
            ans[0] = nums[0];
            i++;
        } 
        for(int j=1;j<n-1;j++){
            if(nums[j]>nums[j-1] && nums[j]>nums[j+1]){
                ans[i] = nums[j];
                j++;
                i++;
            }
        }
        if(nums[n-1]>nums[n-2]){
            ans[i] = nums[n-1];
        } 
        return ans;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        int ans[] = getPeak(arr,n);
        Arrays.sort(ans);
        for(int i:ans){
            if(i!=0) System.out.print(i+" ");
        }
        sc.close();
    }
}
