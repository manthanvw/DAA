/*In a village, there was an ancient chest said to be filled with precious gems, 
each with its own unique mystical power. The chest contained an array of these gems, 
and every gem had a special characteristic: 
they appeared in pairs, and they had the uncanny ability to form an even number of twins. 
But there was one gem, the "Odd Gem," that had a strange peculiarity - it appears an odd number of times. 
It was unique, and its power was different from all the others.
Your task is to find that odd gem.

Note : 1. If the identical elements appear in pairs in the array and there 
cannot be more than two consecutive occurrences of an element, 
find the odd occurring element in logarithmic time and constant space.

2. For instance, both these arrays are invalid – {1, 2, 1} and   
{1, 1, 2, 2, 2, 3, 3}. 
The first one doesn’t have identical elements appear in pairs, and the 
second one contains three consecutive instances of an element. 
On the other hand, the array {2, 2, 3, 3, 2, 2, 4, 4, 3, 1, 1} is valid, and the odd 
occurring element present in it is 3.

input format : an integer n
n number of integers
output format : an integer
Example 1 :
input =13
2 2 1 1 3 3 2 2 4 4 3 1 1
output = 3
Example 2:
input = 11
1 1 2 2 3 3 4 5 5 6 6
4
*/
import java.util.*;
public class PairsofGems {
    static int getOddGem(int[] nums,int low,int high){
        if(low==high){
            return nums[low];
        }
        int mid = (low+high)/2;
        if(low<=high){
            if(mid%2 ==0){
                if(nums[mid]==nums[mid+1]) return getOddGem(nums,mid+2,high);
                else return getOddGem(nums, low, mid);
            }
            else{
                if(nums[mid]==nums[mid-1]) return getOddGem(nums,mid+1,high);
                else return getOddGem(nums, low, mid-1);    
            }
        }
        else return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = {3,3,1,1,5,2,2,4,4};
        System.out.println(getOddGem(arr, 0, arr.length-1));
        sc.close();
    }
}
