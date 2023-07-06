import java.io.*;
import java.util.*;


// Scnaeer 사용해보기
class Main {
    static int n;
    static int m;
    static int[][] graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        int k = sc.nextInt();

        graph = new int[n][m];
        for(int i = 0; i < k; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            for(int y = y1; y < y2; y++){
                for(int x = x1; x < x2; x++){
                    graph[y][x] = 1;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(graph[i][j] == 0) {
                    result.add(bfs(i, j));
                }
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for(int i : result){
            System.out.print(i + " ");
        }
    }
    public static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static int bfs(int x, int y){
        Queue<Node> q= new LinkedList<>();
        q.offer(new Node(x, y));
        graph[x][y] = 1;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int count = 1;
        while(!q.isEmpty()){
            Node node = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = dx[i] + node.x;
                int ny = dy[i] + node.y;

                if(nx < 0 || nx >= n || ny < 0 || ny >= m){
                    continue;
                }
                if (graph[nx][ny] == 0){
                    count++;
                    graph[nx][ny] = 1;
                    q.offer(new Node(nx, ny));
                }
            }
        }
        return count;
    }
}
