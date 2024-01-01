/*
You are given an integer array matchsticks where matchsticks[i] is the length 
of the ith matchstick.
You want to use all the matchsticks to make one square. 
You should not break any stick, but you can link them up, and each matchstick 
must be used exactly one time.

Return true if you can make this square and false otherwise.
input format = integer n size of array
               n number of space seperated integers
output format = true or false
example 1:
input = 5
1 1 2 2 2
output = true
explanation :You can form a square with length 2, one side of the square came 
two sticks with length 1
eample 2 :
input = 5
3 3 3 3 4
output = false
explanation :You cannot find a way to form a square with all the matchsticks.
*/

import java.util.*;
public class SquareFormation 
{
    public boolean makesquare(int[] nums) 
	{
        int sum = 0;
        for (int i:nums) sum+=i;
        if(sum%4 != 0) return false;
        int edges[] = new int[4];
        return makesquare(nums,0,edges,sum);
    }

    private boolean makesquare(int[] nums, int index, int edges[],int sum) 
	{
	    if(index==nums.length){
	        for (int i=0; i<3; i++) 
	            if(edges[i] != edges[i+1]) 
	                return false; 
	        return true;
	    }
	    for(int i=0;i<4;i++){
	        if(edges[i]<sum/4){
	            edges[i]+=nums[index];
	            if(makesquare(nums,index+1,edges,sum) ==true) return true;
	            edges[i]-=nums[index];
	        }
	    } 
	    return false;
    }

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] ar=new int[n];
		for(int i=0;i<n;i++)
			ar[i]=sc.nextInt();

		System.out.print(new SquareFormation().makesquare(ar));
        sc.close();
    }
}