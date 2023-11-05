/*Mr. Ram is working in a manufacturing industry where items with 
different weights are manufactured. His duty is to pick pairs of items 
whose weight difference is equal to 'k'. Can you help him with a program? 
The condition is not to use extra space.

input format:an integer number n
			 n number of positive integers
			 an integer number k
output format : pairs of integers

Example 1:
input = 8
1 2 3 4 5 6 7 8
3
output =
1 4
2 5
3 6
4 7
5 8
Example 2:
input = 10
5 10 15 20 25 30 35 40 45 50
5
output =5 10
10 15
15 20
20 25
25 30
30 35
35 40
40 45
45 50
*/

import java.util.Arrays;
import java.util.Scanner;

public class FindPairsWithDifference {
    static int BS(int arr[],int l,int r,int n){
        int mid = (l+r)/2;
        if(l<=r){
            if(arr[mid]==n) return mid;
            else if(arr[mid]<n) return BS(arr,mid+1,r,n);
            else return BS(arr,l,mid-1,n);
        }
        return -1; 
    }
    
    static void getPairs(int arr[],int k){
        for(int i=0;i<arr.length;i++){
            int index = BS(arr,i+1,arr.length-1,arr[i]+k);
            if(index!=-1){
                System.out.println(arr[i]+" "+arr[index]);
            }
        }
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        int num = sc.nextInt();
        Arrays.sort(arr);
        getPairs(arr,num);
        sc.close();
    }
}
