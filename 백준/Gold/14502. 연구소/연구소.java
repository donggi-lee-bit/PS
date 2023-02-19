import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    int[] dx = new int[]{0, 0, -1, 1};
    int[] dy = new int[]{-1, 1, 0, 0};
    int globalN;
    int globalM;
    int[][] map;
    int max = 0;


    public static void main(String[] args) throws IOException {
        // 입력
        // 빈 공간 좌표 모아서 3개씩 뽑아내기 dfs
        // 바이러스 퍼뜨리기 bfs
        // 안전 영역 확인
        // 최대값 갱신
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] inputs = new String[n];
        for (int i = 0; i < inputs.length; i++) {
            inputs[i] = br.readLine();
        }

        Main s = new Main();
        System.out.println(s.solution(n, m, inputs));
    }

    private int solution(int n, int m, String[] inputs) {
        globalN = n;
        globalM = m;
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] split = inputs[i].split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        dfs(0);

        return max;
    }

    private void dfs(int depth) {
        if (depth == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < globalN; i++) {
            for (int j = 0; j < globalM; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private void bfs() {
        // 바이러스 퍼뜨려보기 위해 카피맵에
        int[][] copyMap = new int[globalN][globalM];
        for (int i = 0; i < copyMap.length; i++) {
            copyMap[i] = map[i].clone();
        }

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < globalN; i++) {
            for (int j = 0; j < globalM; j++) {
                if (map[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + poll[0];
                int ny = dy[i] + poll[1];

                if (nx >= 0 && ny >= 0 && nx < globalN && ny < globalM) {
                    if (copyMap[nx][ny] == 0) {
                        copyMap[nx][ny] = 2;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        // 안전 영역 확인
        checkSafetyZone(copyMap);
    }

    private void checkSafetyZone(int[][] copyMap) {
        int count = 0;
        for (int i = 0; i < globalN; i++) {
            for (int j = 0; j < globalM; j++) {
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
