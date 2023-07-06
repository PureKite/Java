import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] visit;
    static int[] data;
    static StringBuilder sb = new StringBuilder();
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        data = new int[N];
        visit = new boolean[N];
        arr = new int[M];
        for(int i = 0; i < N; i++){
            data[i] = sc.nextInt();
        }

        Arrays.sort(data);
        backtracking(N, M, 0);
        System.out.println(sb.toString());

    }

    public static void backtracking(int n, int m, int depth) {
        if(m == depth){
            StringBuilder sb2 = new StringBuilder();
            for(int i = 0; i < m; i++){
                sb2.append(arr[i]).append(" ");
            }
            if(!set.contains(sb2.toString())){
                sb.append(sb2.toString()).append("\n");
                set.add(sb2.toString());
            }
            return;
        }
        for(int i = 0; i < n; i++){
            if(!visit[i]){
                visit[i] = true;
                arr[depth] = data[i];
                backtracking(n, m, depth+1);
                visit[i] = false;
            }
        }
    }
}