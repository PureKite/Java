import java.nio.Buffer;
import java.util.*;
import java.io.*;
class Main {
    static int[] arr;
    static int n;
    static int s;
    static int[] data;
    static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        data = new int[n];
        for(int i = 0; i < n; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i < n+1; i++){
            arr = new int[i];
            backtracking(i, 0, 0);
        }
        System.out.println(count);
    }
    public static void backtracking(int m, int depth, int begin){
        if (m == depth){
            int sum = 0;
            for(int i = 0; i < arr.length; i++){
                sum += arr[i];
            }
            if (sum == s){
                count++;
            }
            return;
        }
        for(int i = begin; i < n; i++){
            arr[depth] = data[i];
            backtracking(m, depth+1, i+1);
        }
    }
}
