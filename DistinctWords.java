import java.util.HashSet;
import java.util.Set;
/*There are some cubes, and each cube has an alphabet (from A to Z) 
printed on it. You can construct different, non-empty words using these 
cubes and each of the word length should be 0 < length <= number of cubes.

You are given a string of alphabets S, 
Your task is to findout number of possible non-empty distinct words

Input Format:
-------------
A string S, consist of A-Z letters only.

Output Format:
--------------
Print an integer, number of possible non-empty distinct words.


Sample Input-1:
---------------
EGG

Sample Output-1:
----------------
8

Explanation:
--------------
The possible distinct words are "E", "G", "EG", "GG", "GE", "EGG", "GEG", "GGE".


Sample Input-2:
---------------
MADAM

Sample Output-2:
----------------
89 */

import java.util.*;
public class DistinctWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        int result = countDistinctWords(S);
        System.out.println(result);
        sc.close();
    }

    public static int countDistinctWords(String S) {
        Set<String> distinctWords = new HashSet<>();
        backtrack(S, "", distinctWords);
        return distinctWords.size();
    }

    private static void backtrack(String S, String word, Set<String> distinctWords) {
        if (!word.isEmpty()) {
            distinctWords.add(word);
        }
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            String newS = S.substring(0, i) + S.substring(i + 1);
            backtrack(newS, word + c, distinctWords);
        }
    }
}
