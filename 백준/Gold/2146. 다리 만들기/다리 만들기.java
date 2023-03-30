import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    boolean[][] visited;
    int[] dx = new int[]{0, 0, -1, 1};
    int[] dy = new int[]{1, -1, 0, 0};
    int minDist = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Main s = new Main();
        System.out.println(s.solution(n, map));
    }

    private int solution(int n, int[][] map) {
        visited = new boolean[n][n];
        // 섬마다 번호 붙이기
        int[][] numberMap = setIslandNumber(n, map);

        // 가장 짧은 다리 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (numberMap[i][j] >= 2) { // hmm....
                    visited = new boolean[n][n];
                    bfs(i, j, n, numberMap);
                }
            }
        }
        return minDist;
    }

    private void bfs(int x, int y, int n, int[][] numberMap) {
        int currentIslandNumber = numberMap[x][y];
        visited[x][y] = true;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y, 0));

        while (!q.isEmpty()) {
            Point poll = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + poll.x;
                int ny = dy[i] + poll.y;

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }
                
                if (!visited[nx][ny] && numberMap[nx][ny] != currentIslandNumber) {
                    visited[nx][ny] = true;
                    if (numberMap[nx][ny] == 0) {
                        q.add(new Point(nx, ny, poll.dist + 1));
                    } else {
                        if (minDist > poll.dist) {
                            minDist = poll.dist;
                        }
                    }
                }
            }
        }
    }

    private int[][] setIslandNumber(int n, int[][] map) {
        int islandNumber = 2;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    visited[i][j] = true;
                    map[i][j] = islandNumber;
                    q.add(new int[]{i, j});

                    while (!q.isEmpty()) {
                        int[] poll = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = dx[k] + poll[0];
                            int ny = dy[k] + poll[1];

                            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                                continue;
                            }

                            if (!visited[nx][ny] && map[nx][ny] != 0) {
                                visited[nx][ny] = true;
                                map[nx][ny] = islandNumber;
                                q.add(new int[]{nx, ny});
                            }
                        }
                    }
                    islandNumber++;
                }
            }
        }
        return map;
    }

    static class Point {
        int x;
        int y;
        int dist;

        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
