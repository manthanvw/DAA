import java.util.Scanner;

public class SubStrings {
    static char getVal(int n,int k){
        String s = helper(n,k);
        System.out.println(s);
        return s.charAt(k);
    }
    static String helper(int n,int k){
        if(n==0){
            return "0";
        }
        else{
            String ans = helper(n-1,k);
            int l = ans.length();

            for(int i=0;i<l;i++){
                if(i==k) return ans;
                int a = Integer.parseInt(ans.charAt(i)+"");
                if(a==0) a = 1;
                else a = 0;
                ans=ans+ Integer.toString(a); 
            }
            return ans;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(getVal(n, k));
        sc.close();



    }
}
