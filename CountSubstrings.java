/*
Subhani is working with strings. He is given a word W, his task is to form 
special strings. A string said to be special, if the string is formed 
with only one alphabet or one digit.

Print the number of special substrings can be formed using W.

Input Format:
-------------
A string, W consist of digits and lowercase letters.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
abcde

Sample Output-1:
----------------
5


Sample Input-2:
---------------
aaabbb			

Sample Output-2:
----------------
12

Explanation:
------------
The special strings formed using the word W are:
"aaa","bbb" formed 1 time.
"aa","bb" formed 2 times.
"a","b" formed 3 times.
Total of 12 special strings can be formed.


Sample Input-3:
---------------
binary11100

Sample Output-3:
----------------
15

Explanation:
------------
The special strings formed using the word W are:
"b", "i", "n", "a", "r", "y", "111", "00" formed 1 time
"11", "0" formed 2 times 
"1" formed 3 times

*/

import java.util.*;
public class CountSubstrings {
    public static int getCount(String s){
        int ans = 0;
        int count = 1;
        for (int i=1; i<s.length(); i++){
            // System.out.println(ans+" "+count);
            if(s.charAt(i)==s.charAt(i-1)){
                count++;
            }
            else {
                count = 1;
            }
            ans+=count;
        } 
        return ans+1;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(getCount(s));
        sc.close();
    }
}