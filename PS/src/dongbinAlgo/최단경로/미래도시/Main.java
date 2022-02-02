package dongbinAlgo.최단경로.미래도시;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    /**
     * x : 방문 판매할 회사
     * k : 소개팅을 위해 방문할 회사
     * k -> x
     *
     * 5 7 -> 전체 회사 개수 n, 경로의 개수 m
     * 1 2 ->
     * 1 3
     * 1 4
     * 2 4
     * 3 4
     * 3 5
     * 4 5
     * 4 5 -> x k -> k 들렸다 x로
     * @param start
     */

    public static final int INF = (int) 1e9;

    public static int n, m, x, k;

    public static int[][] graph = new int[101][101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();   // 노드의 개수
        m = sc.nextInt();   // 간선의 개수

        // graph를 무제한 수로 전부 초기화
        for (int i = 0; i < 101; i++) {
            Arrays.fill(graph[i], INF);
        }

        // 자기 자신으로 가는 비용 0 으로 초기화
        // 1번 노드가 1번 노드로 가는.
        // 2번 노드가 2번 노드로 가는. 등등등등등
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        x = sc.nextInt();
        k = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        int distance = graph[1][k] + graph[k][x];

        if (distance >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(distance);
        }
    }
}
