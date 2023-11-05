/*You are given an m x n integer matrix, matrix with the following two properties:
  1. Each row is sorted in non-decreasing order.
  2.The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.

input format : integer numbers m n
               integers in m number of rows and n
	           integer k 
output format: integers r c

Example:
Input: matrix =4 3 
1 3 5 7
10 11 16 20
23 30 34 60 
3
Output: 0 1
Example :
Input: matrix = 4 3 
1 3 5 7
10 11 16 20
23 30 34 60 
13
Output: -1 */

import java.util.Scanner;

public class SearchMatrix {
    static int BSn(int arr[],int k){
        int l = 0,h = arr.length;
        while(l<h){
            int mid = (l+h)/2;
            if(arr[mid]==k) return mid;
            else if(arr[mid]<k) l = mid+1;
            else h = mid;
        }
        return -1;
    }
    static int BS(int arr[][],int r,int c,int n){
        int l=0,h=r;
        if(n<arr[0][0]) System.out.println(-1);
        if(n>arr[r-1][c-1]) System.out.println(-1);
        while(l<h){
            int mid = (l+h)/2;
            if(arr[mid][0]<=n && arr[mid][c-1]>=n){
                int index = BSn(arr[mid],n);
                if(index == -1) System.out.println(-1);
                else System.out.println(mid+" "+index);
                break;
            }
            else if(arr[mid][0]>n) h = mid-1;
            else l = mid+1;
        }
        return -1;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int arr[][] = new int[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++) 
                arr[i][j] = sc.nextInt();
        int num = sc.nextInt();
        BS(arr,m,n,num);
        sc.close();
    }
}
