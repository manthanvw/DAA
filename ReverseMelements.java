/*KMIT exam branch is preparing seating plan for coming examinations,they want to prepare new seating plan for every exam.They asked you to develop a program, which reverse every group of consecutive `m`-students of a subarray list from a given list.

Input format : integer number n(for creating main list with numbers  
                                starting from 1 to n).
               integer number m 
			   integers i and j (start and end index where reversal is to                   be applied).
Note : 1. if m value is greater than length of specified subarray then 
          print the list with out any changes.(example 3)
	   2. If i>=j then print the list with out any changes.


For example,
Example 1 :
Input: n=10
m=3
i=1 j=9
output:[1, 4, 3, 2, 7, 6, 5, 10, 9, 8]

Explanation : start index is 1 and end index is 9. there are 9 elements in that sub array, and "m" value is 3 i.e 3 consecutive elements of this subarray have to be reversed. 
2,3,4 reversed to 4,3,2
5,6,7 reversed to 7,6,5
8,9,10 reversed to 10,9,8
final output is [1, 4, 3, 2, 7, 6, 5, 10, 9, 8]


Example 2:
input :10
3
3 5
output = [1, 2, 3, 6, 5, 4, 7, 8, 9, 10]

Example 3:
input 10
3
3 4
output:[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

*/
import java.util.*;
public class ReverseMelements {
    static void rev(int num[],int i,int j){
        if(i>=j) return;
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
        rev(num,i+1,j-1);
    }
    static void revMEle(int num[],int n,int m,int i,int j){
        if(m <= j-i+1){
            rev(num,i,i+m-1);
            revMEle(num,n,m,i+m,j);
        }
    }
    public static void main (String[] args) {
        int m,n,i,j;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        i = sc.nextInt();
        j = sc.nextInt();
        int ans[] = new int[n];
        for(int x=1;x<=n;x++) ans[x-1] = x;
        // for(int x=0;x<n;x++) System.out.print(ans[x]+" ");
        // System.out.println();
        revMEle(ans,n,m,i,j);
        for(int x=0;x<n;x++) System.out.print(ans[x]+" ");
        // System.out.println();
        sc.close();
    }
}
