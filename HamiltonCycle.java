
import java.util.*;

public class HamiltonCycle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int graph[][] = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                graph[i][j] = sc.nextInt();
            }
        }
        int path[] = new int[n];
        Arrays.fill(path,-1);
        path[0] = 0;
        if(hamiltonCycle(graph,path,1,n)){
            printPath(path);
        }else{
            System.out.println("No Hamilton Cycle");
        }
        sc.close();
    }    
    static boolean hamiltonCycle(int graph[][], int path[], int pos, int n) {
        if (pos == n) {
            if (graph[path[pos - 1]][path[0]] == 1) {
                return true;
            } else {
                return false;
            }
        }
        for (int v = 1; v < n; v++) {
            if (isSafe(v, graph, path, pos)) {
                path[pos] = v;
                if (hamiltonCycle(graph, path, pos + 1, n)) {
                    return true;
                }
                path[pos] = -1;
            }
        }
        return false;
    }
    static boolean isSafe(int v, int graph[][], int path[], int pos) {
        if (graph[path[pos - 1]][v] == 0) {
            return false;
        }
        for (int i = 0; i < pos; i++) {
            if (path[i] == v) {
                return false;
            }
        }
        return true;
    }
    static void printPath(int path[]) {
        System.out.print("Hamilton Cycle: ");
        for (int i = 0; i < path.length; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println(path[0]);
    }
}
