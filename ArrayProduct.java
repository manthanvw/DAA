/*Mr.. Rana is writing mathematics exam. one question is as follows
Given an integer array, replace each element with the product of every other element without using the division operator.
He is facing difficulty to solve this, can you help him to solve this by using your programming skills.

Input format : an integer number n
				n number of integers
output format :List of n integers

For example:
Example 1:
Input: 5  
1 2 3 4 5 
Output:[ 120, 60, 40, 30, 24 ]
 
 Example 2:
Input:6  
 5 3 4 2 6 8
Output:[ 1152, 1920, 1440, 2880, 960, 720 ]*/

import java.util.*;
public class ArrayProduct{
    static int getP(int arr[],int s,int end){
        int ans = 1;
        for(int i=s;i<end;i++){
            ans*=arr[i];
        }
        return ans;
    }
    static int [] getProd(int arr[],int n){
        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            int left = getP(arr,0,i);
            int right = getP(arr,i+1,n);
            ans[i] = left*right;
        }
        return ans;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        int ans [] = getProd(arr,n);
        System.out.println(Arrays.toString(ans));
        sc.close();
    }
}

/*import java.util.*;

public class ArrayProduct {
    static int[] getProd(int arr[], int n) {
        int[] ans = new int[n];
        productHelper(arr, ans, 1, 0, n);
        return ans;
    }

    static int productHelper(int arr[], int ans[], int productSoFar, int currentIndex, int n) {
        if (currentIndex == n) {
            return 1;
        }

        // Calculate the product of elements to the right of the current element
        int productRight = productHelper(arr, ans, productSoFar * arr[currentIndex], currentIndex + 1, n);

        // Calculate the final product including the current element
        ans[currentIndex] = productSoFar * productRight;

        // Update the productSoFar for the next recursive call
        return productSoFar * arr[currentIndex];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans[] = getProd(arr, n);
        System.out.println(Arrays.toString(ans));
    }
}
 */
