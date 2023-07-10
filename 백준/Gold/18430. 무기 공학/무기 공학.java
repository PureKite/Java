import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int[][] dic;
    static boolean[][] visited;
    static int[][] data;
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dic = new int[][] {{0, -1, 1, 0}, {-1, 0, 0, -1}, {-1, 0, 0, 1}, {0, 1, 1, 0}};
        visited = new boolean[n][m];
        data = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = 0;
        dfs(0, 0, 0);
        System.out.println(answer);
    }

    public static void dfs(int i, int j, int sum){
        if (j == m){
            i++;
            j = 0;
        }
        if(i == n){
            answer = Math.max(answer, sum);
            return;
        }

        if(!visited[i][j]){
            for(int k = 0; k < 4; k++){
                int a = dic[k][0], b =  dic[k][1], c = dic[k][2], d = dic[k][3];
                int x = i + a, y = j + b, xx = i + c, yy = j + d;
                if(0 <= x && x < n && 0 <= xx && xx < n && 0 <= y && y < m && 0 <= yy & yy < m && !visited[x][y] && !visited[xx][yy]){
                    visited[x][y] = visited[xx][yy] = visited[i][j] = true;
                    dfs(i, j+1, sum + data[i][j] * 2 + data[x][y] + data[xx][yy]);
                    visited[x][y] = visited[xx][yy] = visited[i][j] = false;
                }
            }
        }
        dfs(i, j+1, sum);
    }
}
