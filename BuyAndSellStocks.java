/*you are  working as a software engineer, you want to earn some passive income, you find the best way is investing in shares.you are analyzing the stock market when to purchase and sell shares.As part of this you are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0 .

Example 1:
input = 6
7 1 5 3 6 4
output = 5
Explanation:
Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you 
sell.

Example 2:
input = 5
7 6 4 3 1
output=0

Example 3:
input = 8
10 9 8 7 9 6 12 10
output = 6
*/

import java.util.Scanner;

public class BuyAndSellStocks {
        static int getProfit(int arr[],int n){
        int min = arr[0];
        int maxProfit = 0;
        for(int i=1;i<n;i++){
            maxProfit = Math.max(maxProfit,arr[i]-min);
            min = Math.min(arr[i],min);
        }
        return maxProfit;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i=0; i<n;i++ ) arr[i] = sc.nextInt();
        System.out.print(getProfit(arr,n));
        sc.close();
    }
}
