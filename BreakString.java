/*Mr.Arun is playing with strings, as part of this he is taking a string and writing all possible non-overlapping substrings within that string.
Can you help him with a program which takes a string as input and return a list of all possible combinations of non-overlapping parenthesized substrings.

input format : String
outputformat : parenthesized substrings

Example 1:
input=abcd
output={abcd}
{abc}{d}
{ab}{cd}
{ab}{c}{d}
{a}{bcd}
{a}{bc}{d}
{a}{b}{cd}
{a}{b}{c}{d}
Example 2 :
input=kmit
output={kmit}
{kmi}{t}
{km}{it}
{km}{i}{t}
{k}{mit}
{k}{mi}{t}
{k}{m}{it}
{k}{m}{i}{t}
*/
import java.util.Scanner;

public class BreakString {
    static final String s = "";
     static void generateCombinations(String str, int i, String output) {
        if (str == null || str.length() == 0) {
            return;
        }
        if (i == str.length()) {
            System.out.println(output);
        }
        for (int j = str.length() - 1; j >= i; j--) {
            String substr = "{" + str.substring(i, j + 1) + "}";
            generateCombinations(str, j + 1, output + substr);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int startIndex = 0;
        generateCombinations(str, startIndex, s);
        sc.close();
    }
}
