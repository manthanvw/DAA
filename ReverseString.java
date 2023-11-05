import java.util.*;
public class ReverseString{
    static void helper(String[] s, int i,int j){
        if(i<=j){
            String a = s[i];
            s[i] = s[j];
            s[j] = a;
            helper(s, i+1, j-1);

        }
    }
    static void reverse(String[] s){
        helper(s, 0, s.length-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.next().split("");
        reverse(s);
        System.out.println(Arrays.toString(s));
        sc.close();
    }
}