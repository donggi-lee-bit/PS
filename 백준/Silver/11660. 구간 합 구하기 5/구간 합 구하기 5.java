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

        int[][] map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) + map[i][j - 1];
            }
        }

        int[][] targets = new int[m][4];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 4; j++) {
                targets[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Main s = new Main();
        System.out.println(s.solution(map, targets));
    }

    private String solution(int[][] map, int[][] targets) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < targets.length; i++) {
            int result = 0;
            int x1 = targets[i][0];
            int y1 = targets[i][1];
            int x2 = targets[i][2];
            int y2 = targets[i][3];
            for (int j = x1; j <= x2; j++) {
                result += map[j][y2] - map[j][y1 - 1];
            }
            sb.append(result).append('\n');
        }
        return sb.toString();
    }

}
