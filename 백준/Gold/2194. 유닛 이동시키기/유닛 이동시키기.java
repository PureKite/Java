import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int a;
    static int b;
    static int[][] data;
    static boolean[][] visit;
    static ArrayDeque<int []> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        data = new int[n][m];
        visit = new boolean[n][m];
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            data[x-1][y-1] = -1;
            visit[x-1][y-1] = true;
        }
        st = new StringTokenizer(br.readLine());
        int s_x = Integer.parseInt(st.nextToken()), s_y = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int e_x = Integer.parseInt(st.nextToken()), e_y = Integer.parseInt(st.nextToken());


        q.offer(new int[] {s_x-1, s_y-1});
        visit[s_x-1][s_y-1] = true;
        bfs();
        int num = data[e_x-1][e_y-1];
        if(num == 0){
            System.out.println(-1);
        }else{
            System.out.println(num);
        }
    }

    public static void bfs(){
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};
        while(!q.isEmpty()){
            int[] dir = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = dir[0] + dx[i];
                int ny = dir[1] + dy[i];

                if (check(nx, ny)){
                    data[nx][ny] = data[dir[0]][dir[1]] + 1;
                    visit[nx][ny] = true;
                    q.offer(new int[] {nx, ny});
                }
            }

        }
    }
    public static boolean check(int x, int y){
        if(0 > x || x >= n || 0 > y || y >= m){
            return false;
        }
        else{
            if(visit[x][y] == true){
                return false;
            }
        }
        for(int i = x; i < x+a; i++){
            if(0 > i || i >= n){
                return false;
            }
            for(int j = y; j < y + b; j++){
                if(0 > j || j >= m){
                    return false;
                }
                if (data[i][j] == -1){
                    return false;
                }
            }
        }
        return true;
    }
}
