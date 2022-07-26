import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int m;
    static int n;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int[] arr2;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        arr2 = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr2);

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
        int before = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            } else if (before != arr2[i]) {
                visited[i] = true;
                arr[depth] = arr2[i];
                before = arr2[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}

