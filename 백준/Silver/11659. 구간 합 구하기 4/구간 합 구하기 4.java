import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] arr2 = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr2[i][0] = Integer.parseInt(st.nextToken());
            arr2[i][1] = Integer.parseInt(st.nextToken());
        }

        Main s = new Main();
        System.out.println(s.solution(n, m, arr, arr2));
    }

    public String solution(int n, int m, int[] arr, int[][] arr2) {
        StringBuilder sb = new StringBuilder();
        int[] dp = new int[n + 1];
        dp[0] = arr[0];
        dp[1] = arr[1];
        for (int i = 1; i <= n; i++) {
            dp[i] = arr[i] + dp[i - 1];
        }

        for (int i = 0; i < m; i++) {
            int num1 = arr2[i][0] - 1;
            int num2 = arr2[i][1];
            sb.append(dp[num2] - dp[num1]).append("\n");
        }
        return sb.toString();
    }

}
