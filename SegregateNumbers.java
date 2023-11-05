/*You are given an array of integers which contains positive and negative integers, you have to rearrange this array , preserving the original order, so that positive numbers appear after negative ones. Ensure that the relative positions of elements remain unchanged. Write a program to perform this segregation without altering the sequence of positive and negative integers.
input format : integer number n
                n number of integers (which is a mix of positive and negative integers)
output format : List of integers

For example,
Example 1:
Input: 8  
9 -3 5 -2 -8 -6 1 3
Output: [-3, -2, -8, -6, 9, 5, 1, 3]
Example 2:
Input : 8
5 -4 3 -4 2 1 -5 -6
output :[-4, -4, -5, -6, 5, 3, 2, 1]
*/

import java.util.Arrays;
import java.util.Scanner;

public class SegregateNumbers {
    public static void merge(int[] arr, int[] aux, int low, int mid, int high) {
        int k = low;
        for (int i = low; i <= mid; i++) 
            if (arr[i] < 0) aux[k++] = arr[i];
        
        for (int j = mid + 1; j <= high; j++)  
            if (arr[j] < 0) aux[k++] = arr[j];
        
        for (int i = low; i <= mid; i++) 
            if (arr[i] >= 0) aux[k++] = arr[i];
        
        for (int j = mid + 1; j <= high; j++) 
            if (arr[j] >= 0) aux[k++] = arr[j];
        
        for (int i = low; i <= high; i++) 
            arr[i] = aux[i];
        
    }

    public static void partition(int[] arr, int[] aux, int l, int h) {
        if (h<= l) {
            return;
        }
        int mid = l+ (h - l) / 2;
        partition(arr, aux, l, mid);
        partition(arr, aux, mid + 1, h);
        merge(arr, aux, l, mid, h);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int[] aux = Arrays.copyOf(arr, arr.length);
        partition(arr, aux, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        sc.close();
    }
}
