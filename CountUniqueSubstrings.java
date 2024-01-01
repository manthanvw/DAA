/*
Subhani is working with strings. He is given a word W, his task is to form 
special strings. A string said to be special, if the string is formed 
with only one alphabet or one digit. 
 
Print the number of  unique special substrings can be formed using W.

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
6
*/

import java.util.*;
public class CountUniqueSubstrings {
    public static int getCount(String s){
        HashSet<String> hs = new HashSet<>();
        int i=0;
        int j=0;
        while(i<=j && j<s.length()){
            if(s.charAt(i)==s.charAt(j)){
                String sub = s.substring(i,j+1);
                hs.add(sub);
                j++;
            }
            else{
                i=j;
            }
        }
        return hs.size();
        
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(getCount(s));
        sc.close();
    }
}