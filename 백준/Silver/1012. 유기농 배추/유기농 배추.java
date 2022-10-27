import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    boolean[][] visited;
    int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int m, n, k;
        Main s = new Main();
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            int[][] arr = new int[k][2];
            for (int j = 0; j < k; j++) {
                String[] split = br.readLine().split(" ");
                arr[j][0] = Integer.parseInt(split[0]);
                arr[j][1] = Integer.parseInt(split[1]);
            }
            System.out.println(s.solution(m, n, arr));
        }
    }

    public int solution(int m, int n, int[][] arr) {
        map = new int[m][n];
        visited = new boolean[m][n];
        for (int[] point : arr) {
            int x = point[0];
            int y = point[1];

            map[x][y] = 1;
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    dfs(i, j);
                    answer++;
                }
            }
        }
        return answer;
    }

    private void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) {
                continue;
            }

            if (!visited[nx][ny] && map[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }

}
