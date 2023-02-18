import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    int[] dx = new int[]{0, 0, -1, 1};
    int[] dy = new int[]{-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] inputs = new String[N];
        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = br.readLine();
        }

        Main s = new Main();
        System.out.println(s.solution(N, M, inputs));
    }

    public int solution(int n, int m, String[] inputs) {
        int[][] map = new int[n][m];
        int[][] dist = new int[n][m];
        for (int i = 0; i < inputs.length; i++) {
            String[] split = inputs[i].split("");
            for (int j = 0; j < split.length; j++) {
                map[i][j] = Integer.parseInt(split[j]);
                dist[i][j] = -1;
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        dist[0][0] = 0;

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + poll[0];
                int ny = dy[i] + poll[1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (map[nx][ny] != 1 || dist[nx][ny] != -1) {
                    continue;
                }

                q.add(new int[]{nx, ny});
                dist[nx][ny] = dist[poll[0]][poll[1]] + 1;
            }

        }


        return dist[n - 1][m - 1] + 1;
    }

}
