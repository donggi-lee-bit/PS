import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // R행, C열
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];
        LinkedList<int[]> queue = new LinkedList<>();
        LinkedList<int[]> waterQueue = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);

                if (map[i][j] == 'S') {
                    queue.offer(new int[]{i, j, 0});
                }

                if (map[i][j] == '*') {
                    waterQueue.offer(new int[]{i, j});
                }
            }
        }

        int[] dx = new int[]{1, 0, 0, -1};
        int[] dy = new int[]{0, 1, -1, 0};
        int answer = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            // 루프가 돌 때마다 물 위치 업데이트
            int length = waterQueue.size();
            for (int i = 0; i < length; i++) {
                int[] water = waterQueue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = dx[j] + water[0];
                    int ny = dy[j] + water[1];
                    if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] == '.') {
                        map[nx][ny] = '*';
                        waterQueue.offer(new int[]{nx, ny});
                    }
                }
            }

            length = queue.size();
            for (int i = 0; i < length; i++) {
                int[] current = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = current[0] + dx[j];
                    int ny = current[1] + dy[j];
                    int times = current[2];
                    if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                        if (map[nx][ny] == 'D') {
                            answer = Math.min(answer, times + 1);
                        } else if (map[nx][ny] == '.') {
                            map[nx][ny] = 'S';
                            queue.offer(new int[]{nx, ny, times + 1});
                        }
                    }
                }
            }
        }

        // 고슴도치가 비버의 굴에 도착하지 못했다면 answer의 초기값이 MAX_VALUE
        System.out.println(answer == Integer.MAX_VALUE ? "KAKTUS" : answer);
    }
}
