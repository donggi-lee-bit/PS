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

    public int solution(int n, int m, String[] inputs) {
        globalN = n;
        globalM = m;
        map = new int[n][m];
        for (int i = 0; i < inputs.length; i++) {
            String[] s = inputs[i].split(" ");
            for (int j = 0; j < s.length; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        dfs(0);
        return max;
    }

    private void dfs(int depth) {
        // 좌표 x, y가 0인 3개의 좌표를 모아서 조합을 이용해서 3개씩 뽑아내게 한다
        // dfs 사용
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
        // 3개의 벽을 세웠으면 바이러스를 퍼뜨려본다
        // bfs
        // 남아있는 안전 영역을 카운팅한다
        // 반복
        Queue<int[]> q = new LinkedList<>();
        // Queue 에는 바이러스 좌표를 담는다
        for (int i = 0; i < globalN; i++) {
            for (int j = 0; j < globalM; j++) {
                if (map[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        // 원본 맵에 영향을 주지 않기 위해 사본
        // deep copy 를 clone() 메서드를 이용하는구나
        int[][] copyMap = new int[globalN][globalM];
        for (int i = 0; i < globalN; i++) {
            copyMap[i] = map[i].clone();
        }

        // bfs start
        while (!q.isEmpty()) {
            int[] poll = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + poll[0];
                int ny = dy[i] + poll[1];

                // 연구소 범위 밖이 아니고 빈칸일 경우에만 바이러스를 퍼뜨린다
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
