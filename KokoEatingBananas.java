/*We are given an array of size n which contains the number of bananas in 
each pile. In one hour Koko can eat at most K bananas. 
If the pile contains less than K bananas in that case if Koko finishes 
all bananas of that pile then she cannot start eating bananas from another pile 
in the same hour.
Koko wants to eat all bananas within H hours. 
We are supposed to find the minimum value of K.

Sample Input-1:
---------------
4 8 9 13
8
Sample Output-1:
----------------
5

Sample Input-2:
---------------
15 18 12 17 22
7
Sample Output-2:
----------------
17
*/

import java.util.Scanner;

public class KokoEatingBananas {
 static int getTime(int arr[],int val){
        int count = 0;
        // System.out.print(val+" ");
        for(int i:arr){
            count += Math.ceil((double)(i/val))+1;
            if(i%val == 0) count--;
        }
        // System.out.println();
        return count;
    }
    static int getMax(int arr[]){
        int max = Integer.MIN_VALUE;
        for(int i:arr) max = Math.max(max,i);
        return max;
    }
    static int bph(int arr[],int n){
        int l = 1;
        int h = getMax(arr);
        int ans = h;
        while(l<=h){
            int mid = l+(h-l)/2;
            int time = getTime(arr,mid);
            // System.out.println(mid+" "+time);
            if(time<=n){
                ans = Math.min(ans,mid);
                h = mid-1;
            }
            else l=mid+1;
        }
        return ans;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s[] = sc.nextLine().split(" ");
        int n = sc.nextInt();
        int arr[] = new int[s.length];
        for(int i=0;i<arr.length;i++) arr[i] = Integer.parseInt(s[i]);
        // System.out.println(Arrays.toString(arr));
        System.out.println(bph(arr,n));
        sc.close();
    }   
}
