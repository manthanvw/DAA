import java.util.*;
public class KrushkalAlgo{
    static void getMinSpanTree(int arr[][],int v,int e){
        boolean ver[] = new boolean[v];
        int count =0;
        for (int i = 0; i < ver.length; i++) {
            ver[i] = false;
        }
        for(int i[]:arr){
            if(ver[i[0]]==false || ver[i[1]]==false ){
                ver[i[0]] = true;
                ver[i[1]] = true;
                System.out.println(i[0]+" "+i[1]+" "+i[2]);
                count+=i[2];
            }
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        // Scanner sc =  new Scanner(System.in);
        // int v = sc.nextInt();
        // int e = sc.nextInt();
        // int arr[][] = new int[e][3];
        // for(int i=0;i<e;i++){
        //     arr[i][0]=sc.nextInt();
        //     arr[i][1]=sc.nextInt();
        //     arr[i][2]=sc.nextInt();
        // }
        int v = 4;
        int e = 5;
        int arr[][] = {{0,1,3},{0,2,5},{2,3,1},{1,2,4},{1,3,5}};
        Arrays.sort(arr,(a,b)->{return (a[2]-b[2]);});
        System.out.println(Arrays.deepToString(arr));
        getMinSpanTree(arr,v,e);
    }
}