import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] visited;
    static int[][] map;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{1, -1, 0, 0};
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(st.nextToken()); // 가로
            n = Integer.parseInt(st.nextToken()); // 세로
            map = new int[m][n];
            int k = Integer.parseInt(st.nextToken()); // 배추 심어져 있는 위치의 개수
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            // 1이 있는 위치부터 dfs를 해서 배추흰지렁이 카운팅
            visited = new boolean[m][n];
            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
//                        visited[i][j] = true;
                        count++;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx >= m || ny >= n || nx < 0 || ny < 0) {
                continue;
            }

            if (!visited[nx][ny] && map[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }

}
