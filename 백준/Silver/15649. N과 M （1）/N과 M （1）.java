import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    StringBuilder sb = new StringBuilder();
    int[] arr;
    boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Main s = new Main();
        System.out.println(s.solution(N, M));
    }

    public String solution(int n, int m) {
        arr = new int[m];
        visited = new boolean[n];
        dfs(0, n, m);
        return sb.toString();
    }

    private void dfs(int depth, int n, int m) {
        if (depth == m) {
            for (int value : arr) {
                sb.append(value).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(depth + 1, n, m);
                visited[i] = false;
            }

        }
    }
}
