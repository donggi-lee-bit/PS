import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    int[][] directions = new int[][]{
        // 처음이 오른쪽
        {0, 1},
        {1, 0},
        {0, -1},
        {-1, 0}
        // 오른쪽 방향에서 왼쪽 90도로 틀면 위로 가야하니까 0 에서 마이너스가 나오면 3이 되게
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 보드의 크기 N
        int k = Integer.parseInt(br.readLine()); // 사과의 위치 K 행 열로
        int[][] points = new int[k][2];
        StringTokenizer st;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }
        int l = Integer.parseInt(br.readLine()); // 뱀의 방향 변환 정보 정수 x, 문자 c
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            map.put(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        Main s = new Main();
        System.out.println(s.solution(n, k, points, l, map));
    }

    public int solution(int n, int k, int[][] points, int l, Map<Integer, String> map) {
        boolean[][] snake = new boolean[n + 2][n + 2]; // 자기 자신과 부딪히면 끝 || 벽이랑 부딪혀도 끝
        boolean[][] apple = new boolean[n + 1][n + 1];
        int count = 0;
        int nowDir = 0;
        Queue<int[]> q = new LinkedList<>();
        snake[1][1] = true;
        // 사과 좌표 추가
        for (int[] point : points) {
            apple[point[0]][point[1]] = true;
        }
        // bfs 초기값
        int[] now = new int[]{1, 1};
        q.offer(now);
        snake[now[0]][now[1]] = true;

        // 뱀의 꼬리를 알기 위한 뱀 정보
        List<int[]> snakeInformation = new ArrayList<>();
        snakeInformation.add(new int[]{1, 1});

        // bfs 시작
        while (!q.isEmpty()) {
            count++;
            int[] poll = q.poll();
            now = new int[]{poll[0] + directions[nowDir][0], poll[1] + directions[nowDir][1]};

            // 종료
            if (snake[now[0]][now[1]] ||
                now[0] > n || now[1] > n ||
                now[0] < 1 || now[1] < 1) {
                break;
            }

            // 사과
            if (!apple[now[0]][now[1]]) {
                // 사과가 없다면
                // 뱀 꼬리 최신화
                int[] snakeTail = snakeInformation.get(0);
                snake[snakeTail[0]][snakeTail[1]] = false;
                snakeInformation.remove(0);
            } else {
                // 사과가 있으면
                apple[now[0]][now[1]] = false;
            }
            snakeInformation.add(new int[]{now[0], now[1]});
            snake[now[0]][now[1]] = true; // 뱀 머리

            // 방향
            if (map.containsKey(count)) { // 방향 변환 정보에 속한 X초가 있으면 -> 방향 바꿔야죠
                if (map.get(count).equals("D")) { // D는 오른쪽 90도
                    if (nowDir == 3) {
                        nowDir = 0;
                    } else {
                        nowDir++;
                    }
                } else {
                    // L 은 왼쪽 90도
                    if (nowDir == 0) {
                        nowDir = 3;
                    } else {
                        nowDir--;
                    }
                }
            }
            q.offer(now);

        }
        return count;
    }

}
