import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());   // 5 2
        int k = Integer.parseInt(st.nextToken());
        dp = new int[200][200];

        System.out.println(dpBc(n, k));
    }

    private static long dpBc(int n, int k) {
        if (dp[n][k] > 0) {
            return dp[n][k];
        }

        if (n == k || k == 0) {
            return dp[n][k] = 1;
        } else {
            return dpBc(n - 1, k) + dpBc(n - 1, k - 1);
        }
    }
}
