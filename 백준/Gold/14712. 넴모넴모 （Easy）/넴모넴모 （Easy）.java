import java.util.*;
import java.io.*;

class Main{
    static int n;
    static int m;
    static int[][] graph;
    static int count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n+1][m+1];
        back(0);
        System.out.println(count);
    }
    public static void back(int depth){
        if(depth == n * m){
            count++;
            return;
        }

        int x = depth / m + 1;
        int y = depth % m + 1;

        back(depth+1);
        if (graph[x-1][y] == 0 || graph[x][y-1] == 0 || graph[x-1][y-1] == 0){
            graph[x][y] = 1;
            back(depth+1);
            graph[x][y] = 0;
        }
    }
}