import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};
    boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[][] map = new String[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split("");
        }

        Main s = new Main();
        System.out.println(s.solution(n, map));
    }

    public String solution(int n, String[][] map) {
        StringBuilder sb = new StringBuilder();
        visited = new boolean[n][n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, map, n);
                    count++;
                }

            }
        }

        sb.append(count).append(" ");
        visited = new boolean[n][n];
        count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j].equals("G")) {
                    map[i][j] = "R";
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, map, n);
                    count++;
                }
            }
        }
        sb.append(count);

        return sb.toString();
    }

    private void dfs(int x, int y, String[][] map, int n) {
        String firstValue = map[x][y];
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                continue;
            }

            if (!visited[nx][ny] && map[nx][ny].equals(firstValue)) {
                visited[nx][ny] = true;
                dfs(nx, ny, map, n);
            }
        }
    }
}
