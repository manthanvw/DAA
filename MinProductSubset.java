import java.util.*;

public class MinProductSubset {

    static long getMinProd(int arr[], int size) {
        int n = 0;
        int z = 0;
        long ans = 1;
        int nMax = Integer.MIN_VALUE;
        int pMin = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            if (arr[i] < 0) {
                n++;
                nMax = Math.max(arr[i], nMax);
            } else if (arr[i] > 0) {
                pMin = Math.min(pMin, arr[i]);
            } else {
                z++;
                continue;
            }
            ans = ans * arr[i];
        }
        if (n > 0 && n % 2 == 0) {
            ans = ans / nMax;
            return ans;
        } else if (n > 0) {
            return ans;
        } else if (n == 0 && z > 0) {
            return 0;
        } else {
            return pMin;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int flag = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ',') {
                flag = 1;
                break;
            } else if (str.charAt(i) == ' ') {
                flag = 0;
                break;
            }
        }
        String s[];
        if (flag == 1) {
            s = str.split(",");
        } else {
            s = str.split(" ");
        }
        int arr[] = new int[s.length];
        for (int i = 0; i < s.length; i++)
            arr[i] = Integer.parseInt(s[i]);
        System.out.println(getMinProd(arr, s.length));
        sc.close();
    }
}