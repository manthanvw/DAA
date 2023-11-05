/*
Mr. Dharma went to D-mart, and picked a basket with a capacity C.
There are N products in Dharma's wishlist.
You will be given desired cost and quantity of each Product.
Out of the wishlist Mr Dharma has, he wants to purchase the products in the following way:
	- The sum of quantities taken into the basket is less than or equal to C.
	- The sum of cost of the products in the basket is maximum among all 
	the possible combinations of products.

Your task is to help, Mr. Dharma to purachase the products with maximum cost, 
with the given basket capacity. 

Input Format:
-------------
Line-1: input an integer N.
Next N lines: Two space separated integers, cost and quantity of each product.
Last line: input an integer C (basket capacity)

Output Format:
--------------
Print an integer, Maximum cost to pay to D-Mart.

Sample Test Cases:
TC1:
Input:
4
2 1
4 3
7 5
10 7
8
Output: 12

TC2:
Input:
4
10 2
10 4
12 6
18 9
15
Output: 38.0

TC3:
Input:
4
18 6
20 3
14 5
18 9
21
Output: 66.0
*/

import java.util.Arrays;
import java.util.Scanner;

public class FractionalKnapsack {
    static double getCost(double arr[][],int n,double cap){
        double cost = 0;
        for (int i=0; i<n;i++ ){
            if(cap - arr[i][1]>=0){
                cost+= arr[i][0];
                cap = cap-arr[i][1];
            }
            else{
                double left = (double)(cap/arr[i][1]);
                cost+= left*arr[i][0];
                break;
            }
        }
        return cost;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double arr[][] = new double[n][2];
        for (int i=0; i<n; i++){
            arr[i][0] = sc.nextDouble();
            arr[i][1] = sc.nextDouble();
        } 
        double cap = sc.nextDouble();
        Arrays.sort(arr,(a,b)->{
            if((double)(a[0]/a[1]) < (double)(b[0]/b[1])) return 1;
            else return -1;
        });
        System.out.println(getCost(arr,n,cap));
        sc.close();
    }
}
