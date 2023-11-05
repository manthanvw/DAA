/*Given a matrix where every row is sorted in increasing order. 
Write a function that finds and returns a common element in all rows. 
If there is no common element, then returns -1. 

Sample Test Cases :
Case 1:
Input :=
4 5
1 2 3 4 5
5 6 7 8 9
4 5 6 7 8
2 3 4 5 6
output :=5

Case 2:
input :=
5 4
10 30 45 46
1 2 10 20
10 12 13 14
2 3 4 10
7 8 9 10
output =10
*/

import java.util.Scanner;

public class SmallestCommonElement {
        static int BS(int arr[],int l,int r,int n){
        int mid = (l+r)/2;
        if(l<r){
            if(arr[mid]==n) return mid;
            else if(arr[mid]<n) return BS(arr,mid+1,r,n);
            else return BS(arr,l,mid,n);
        }
        return -1; 
    }
    
    static int getCommonElement(int arr[][],int n,int m){
        int count = 0;
        for(int i:arr[0]){
            count=0;
            for(int j=1;j<m;j++){
                if(BS(arr[j],0,n,i)!=-1){
                    count++;
                }
            }
            if(count ==m-1) return i;
        }
        return -1;
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int arr[][] = new int[m][n];
        for(int i=0;i<m;i++) for(int j=0;j<n;j++) arr[i][j] = sc.nextInt();
        int ans = getCommonElement(arr, n, m);
        System.out.println(ans);
        sc.close();
    }

}
