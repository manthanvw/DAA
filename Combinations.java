/*
/*You are attending an interview, interviewer given a positive integer n,asked you to print all combinations of numbers between 1 and n having sum 'm'.Write a program to do this task.
Note : 1. To avoid ambiguity, combination will be constructed in  
          non-decreasing order.
	   2. Distinct combinations are to be printed, i.e [1,2] and [2,1]   
	      are same, if [1,2] is printed then avoid [2,1].
	   2. m <= n.

input format: two integer numbers n and m
output format : lists
Example :
For n = 5,m=5 the following combinations are possible:
1 1 1 1 1
1 1 1 2
1 1 3
1 2 2
1 4
2 3
5
Example 2:
input = 4 3
output =
1 1 1
1 2
3
*/

import java.util.*;
public class Combinations{

    public static void generateCombinations(int start, int remaining, int[] output, int currentIndex) {
        if (remaining == 0) {
            for (int k = 0; k < currentIndex; k++) {
                System.out.print(output[k] + " ");
            }
            System.out.println();
        }
        for (int j = start; j <= remaining; j++) {
            output[currentIndex] = j;
            generateCombinations(j, remaining - j, output, currentIndex + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int targetSum = sc.nextInt();
        int[] outputArray = new int[total];
        generateCombinations(1, targetSum, outputArray, 0);
        sc.close();
    }
}