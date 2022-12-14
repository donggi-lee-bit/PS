import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int[] dx = new int[]{0, 0, -1, 1};
    int[] dy = new int[]{-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] map = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Main s = new Main();
        System.out.println(s.solution(m, n, map));
    }

    public int solution(int m, int n, int[][] map) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        return dfs(1, 1, dp, map, m, n);
    }

    private int dfs(int x, int y, int[][] dp, int[][] map, int m, int n) {
        if (x == m && y == n) {
            return 1;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx < 1 || ny < 1 || nx > m || ny > n) {
                continue;
            }

            if (map[x][y] > map[nx][ny]) {
                dp[x][y] += dfs(nx, ny, dp, map, m, n);
            }
        }

        return dp[x][y];
    }

}
