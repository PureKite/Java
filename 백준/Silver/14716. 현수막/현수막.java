import java.io.*;
import java.util.*;

class Main {
    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};
    static int n;
    static int m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];

        for(int i = 0; i < n; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;

        for(int i = 0; i < n; i ++){
            for(int j = 0; j < m; j++){
                if(graph[i][j] == 1){
                    bfs(i, j);
                    count += 1;
                }
            }
        }
        System.out.println(count);
    }
    public static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        graph[x][y] = 0;
        q.offer(new Node(x, y));
        while(!q.isEmpty()){
            Node node = q.poll();

            for(int i = 0; i < 8; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m){
                    continue;
                }
                if (graph[nx][ny] == 1){
                    graph[nx][ny] = 0;
                    q.offer(new Node(nx, ny));
                }
            }

        }
        return;
    }
}
