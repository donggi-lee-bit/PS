import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int m;
    static int n;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[m];
        visited = new boolean[n];
        dfs(0);
        System.out.println(sb);
    }

    private static void dfs(int depth) {
        // 탈출 조건
        if (depth == m) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        // dfs
        for (int i = 0; i < n; i++) {
            arr[depth] = i + 1;
            dfs(depth + 1);
        }
    }
}
