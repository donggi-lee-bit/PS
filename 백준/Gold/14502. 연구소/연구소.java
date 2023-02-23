import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    int[] dx = new int[]{0, 0, -1, 1};
    int[] dy = new int[]{-1, 1, 0, 0};
    int max = Integer.MIN_VALUE;
    boolean[][] visited;
    int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] inputs = new String[N];
        for (int i = 0; i < N; i++) {
            inputs[i] = br.readLine();
        }

        Main s = new Main();
        System.out.println(s.solution(N, M, inputs));

    }

    private int solution(int n, int m, String[] inputs) {
        // 3개의 벽 세우기 백트래킹
        // 바이러스 퍼뜨리기 bfs 로 0 -> 2
        // 바이러스를 퍼뜨린 후 남은 0의 개수 갱신 max
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] split = inputs[i].split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        visited = new boolean[n][m];
        dfs(0, n, m);
        return max;
    }

    private void dfs(int depth, int n, int m) {
        if (depth == 3) {
            bfs(n, m);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(depth + 1, n, m);
                    map[i][j] = 0;
                }
            }
        }
    }

    private void bfs(int n, int m) {
        int[][] copyMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            copyMap[i] = map[i].clone();
        }

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + poll[0];
                int ny = dy[i] + poll[1];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (copyMap[nx][ny] == 0) {
                        copyMap[nx][ny] = 2;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] == 0) {
                    count++;
                }
            }
        }

        if (max < count) {
            max = count;
        }
    }

}
