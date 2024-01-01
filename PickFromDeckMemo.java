
/*Given D decks of C cards, each card numbered from 1,2,3,..C.
You have to pick a card in random from each deck, and 
find the sum of the numbers on cards selected.

If the sum is equals the target, you can say "Target Achieved".

Return the number of ways W, that makes you to say "Target Achieved".

Input Format:
-------------
Three integers D, C, and Target.

Output Format:
--------------
Print the value of W

Sample Input-1:
---------------
1 6 3

Sample Output-1:
----------------
1

Explanation: 
--------------
You select one card from the deck of 6 cards.  There is only one way to get a sum of 3.

Sample Input-2:
---------------
2 6 7

Sample Output-2:
----------------
6

Explanation: 
--------------
You select one card each from two decks, each deck has 6 cards.  
There are 6 ways to get a sum of 7:
1+6, 2+5, 3+4, 4+3, 5+2, 6+1.


Sample Input-3:
---------------
2 5 10

Sample Output-3:
----------------
1

Explanation: 
--------------
You select one card each from two decks, each deck has 5 cards.  
There is only one way to get a sum of 10: 5+5.

Sample Input-4:
---------------
1 2 3

Sample Output-4:
----------------
0

Explanation: 
--------------
You select one card from the deck of 2 cards.  There is no way to get a sum of 3.



	Time complexity: O(d * c * target)
	Space complexity: O(d * target)

 */
import java.util.*;
public class PickFromDeckMemo {
    public static int pickFromDeck(int D, int C, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return helper(D, C, target, memo);
    }
    
    private static int helper(int D, int C, int target, Map<String, Integer> memo) {
        if (D == 0) {
            return target == 0 ? 1 : 0;
        }
        
        String key = D + "-" + target;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        int ways = 0;
        for (int i = 1; i <= C; i++) {
            if (target - i >= 0) {
                ways += helper(D - 1, C, target - i, memo);
            }
        }
        
        memo.put(key, ways);
        return ways;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int D = sc.nextInt();
        int C = sc.nextInt();
        int target  = sc.nextInt();
        int ans = pickFromDeck(D,C,target);
        System.out.println(ans);
        sc.close();
    }
}

// import java.util.*;
// public class PickFromDeckMemo{
//     static int ans = 0;
//     public static void getCount(int n,int max,int target,int i){
//         if(n==0 && target==0){
//             ans++;
//         }
//         if(target<0) return;
        
//         for (int k=i; k<=max; k++){
//             getCount(n-1,max,target-k,i+1);
//         }
         
//     }
//     public static void main (String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int max = sc.nextInt();
//         int target  = sc.nextInt();
//         getCount(n,max,target,0);
//         System.out.println(ans);
//         sc.close();
//     }
// }