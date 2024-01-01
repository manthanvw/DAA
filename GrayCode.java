/*
Given a integer value N, indicates number of bits in a binary number.
Your task is to design a Binary Code System, 
where two consecutive values in BCS having N bits, must have one bit difference only.
For example refer the sample testcases.

Find and print the integer values of BCS, starting from 0.

Input Format:
-------------
A integer N, number of bits in BCS

Output Format:
--------------
Print the list of integer values, in BCS form. 


Sample Input-1:
---------------
2

Sample Output-1:
----------------
[0, 1, 3, 2]

Explanation:
------------
00 - 0
01 - 1
11 - 3
10 - 2

Sample Input-2:
---------------
3
Sample Output-2:
----------------
[0, 1, 3, 2, 6, 7, 5, 4]

Explanation:
------------
000 - 0
001 - 1
011 - 3
010 - 2
110 - 6
111 - 7
101 - 5
100 - 4

*/
import java.util.*;
class GrayCode 
{
    int nums = 0;
    public List<Integer> grayCode(int n) 
	{
        List<Integer> ret = new ArrayList<>();
        backTrack(n, ret);
        return ret;
    }
     private void backTrack(int n, List<Integer> ret) 
	{
	    //write your program here
	    if(n==0) {
	        ret.add(0);
	        return;
	    }
	    
	    backTrack(n-1,ret);
	    int factor = 1<<(n-1);
        for (int i=ret.size()-1;i>=0;i--){
	            ret.add((ret.get(i) | factor));
	    }
	   // System.out.println(ret+" "+factor);
	    
   }
	public static void main( String args[])
	{
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		System.out.println(new GrayCode().grayCode(N));
        sc.close();
	}
}
