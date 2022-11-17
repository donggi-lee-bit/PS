import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};
    int max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int m = Integer.parseInt(split[0]); // ㄱ가로 칸의 수
        int n = Integer.parseInt(split[1]); // 세로 칸의 수

        String[][] map = new String[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split(" ");
        }

        Main s = new Main();
        System.out.println(s.solution(n, m, map));
    }

    private int solution(int n, int m, String[][] map) {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j].equals("1")) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] current = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + current[0];
                int ny = dy[i] + current[1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (map[nx][ny].equals("0")) {
                    map[nx][ny] = String.valueOf(Integer.parseInt(map[current[0]][current[1]]) + 1);
                    max = Math.max(max, Integer.parseInt(map[nx][ny]));
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        if (checkZero(n, m, map) && max == -1) {
                return 0;
        }

        if (!checkZero(n, m, map)) {
            return -1;
        }
        return max - 1;
    }

    private boolean checkZero(int n, int m, String[][] map) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j].equals("0")) {
                    return false;
                }
            }
        }
        return true;
    }

}
