import java.util.Scanner;

public class HappyNumber {
    static boolean isHappy(int n){
        if(n==1) return true;
        if(n==4) return false;
        else{
            int a = 0;
            while(n>0){
                int b = n%10;
                a =a + b*b;
                n=n/10;
            }
            return isHappy(a);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isHappy(n));
        sc.close();
    }
}
