/*Given an input string s (A line of text).
Each word in line are space seperated. 
Reverse each word in s.
You need to display each revesed word in new line.

sample Test Case:
input=hello world genesis kmit ngit
output=
olleh
dlrow
siseneg
timk
tign
*/

import java.util.Scanner;

public class StringReverse {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s[] = sc.nextLine().split(" ");
        for(String i:s){
            for(int j=i.length()-1;j>=0;j--){
                System.out.print(i.charAt(j));
            }
            System.out.println();
        }
        sc.close();
        
    }
}
