/*Given an array of n distinct integers sorted in ascending order, 
write a function that returns a Fixed Point in the array, if there is 
any Fixed Point present in array, else returns -1. 

Fixed Point in an array is an index i such that arr[i] is equal to i. 
Note that integers in array can be negative.
  

Sample test caes
Case 1:
input:8
16 9 -10 2 -5 4 7 12
output:2

Case 2:
input:8
0 4 2 -5 -3 10 8 6
output:4

Case 3:
input:6
5 1 4 2 3 6
output:-1
*/

import java.util.Arrays;
import java.util.Scanner;

public class FixedPoint {
    static int BS(int arr[],int l,int r){
        int mid = (l+r)/2;
        if(l<r){
            if(arr[mid]==mid) return mid;
            else if(arr[mid]<mid) return BS(arr,mid+1,r);
            else return BS(arr,l,mid);
        }
        return -1; 
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);
        int ans = BS(arr,0,arr.length);
        System.out.println(ans);
        sc.close();
    }
}
