/*Mr.Sathya is solving a puzzle, the problem is given a sorted array which 
contains only 0s and 1s. He has to find total number of 1s in the given list, 
can you write a program to do this task in an efficient way.

*****************************
input Format : integer number n
         n number of integers (contains 0s and 1s only in a sorted order)
output Format :An integer
*****************************
Samples
example 1:
input =5
0 0 1 1 1
output =3
Example 2:
input =10
1 1 1 1 1 1 1 1 1 1
output =10
*/
import java.util.Scanner;

public class NumberOfOnesBS {
    static int helper(int nums[],int n,int low,int high){
        int mid = (low+high)/2;
        if(low<high){
            if(nums[mid] == 0) return helper(nums,n,mid+1,high);
            else return helper(nums,n,low,mid-1);
        }
        return mid;
    }
    static int getIndex(int nums[], int n){
        if(nums[n-1]==0) return 0;
        else if(nums[0] == 1) return n;
        else return n -1- helper(nums,n,0,n);
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        System.out.println(getIndex(arr,n));
        sc.close();
    }
}
