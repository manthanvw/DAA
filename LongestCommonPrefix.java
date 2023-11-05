/*Given the array of strings S[], you need to find the longest string S 
which is the prefix of ALL the strings in the array.
Longest common prefix (LCP) for a pair of strings S1 and S2 is the 
longest string S which is the prefix of both S1 and S2.
For Example: longest common prefix of “abcdefgh” and “abcefgh” is “abc”.

Time complexity: O(NM log M)
N = Number of strings
M = Length of the longest string

Space complexity:
O(M) 
M = Length of the longest string 

Test Cases:
case1:
input=flower flow flight
output=fl

case2:
input=hello hell her he
output=he

case3:
input=anty anticipate ant antacid
output=ant
*/

import java.util.Arrays;
import java.util.Scanner;

public class LongestCommonPrefix {
    public static String findLongestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        Arrays.sort(strs); 
        String first = strs[0];
        String last = strs[strs.length - 1];
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < first.length(); i++) {
            if (i < last.length() && first.charAt(i) == last.charAt(i)) {
                result.append(first.charAt(i));
            } else {
                break;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] words = input.split(" ");
        
        String longestCommonPrefix = findLongestCommonPrefix(words);
        System.out.println(longestCommonPrefix);
        sc.close();
    }
}
