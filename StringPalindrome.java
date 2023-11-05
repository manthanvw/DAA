/* You are writing an english exam, there is one question on reversing strings, 
with your programming skills can you write a program which prints 
True if given string and reverse of that is same otherwise False.

Input format : string
output format : Boolean value
Example :
input= amanaplanacanalpanama
output = True
Example :
input = abccbaabcabaabccba
output = False
*/
import java.util.Scanner;
public class StringPalindrome {
    static boolean isPalin(String s,int i,int j){
        if(i<=j){
            if(s.charAt(i) != s.charAt(j)) return false;
            else return isPalin(s,i+1,j-1);
        }
        return true;
        
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(isPalin(s,0,s.length()-1));
        sc.close();
    }
}
