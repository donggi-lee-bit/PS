package dongbinAlgo.최단경로.쉬운다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

class Node {
    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }
}

public class Main {

    public static final int INF = (int) 1e9;

    public static int n, m, start;

    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static boolean[] visited = new boolean[100001];

    public static int[] d = new int[100001];

    /**
     * getSmallestNode 메서드 :
     * + 해당 노드에 연결된 노드 중 비용이 가장 적은 것부터.
     * 실행 됐을 때 모든 간선을 돌면서 (거리가 짧은 원소 순서로)
     * 방문 하지 않으면서 더 작은 경우의 수를 가진 인덱스가 있으면
     * min value 를 해당 인덱스로 바꾸고
     */
    public static int getSmallestNode() {
        int min_value = INF;
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (d[i] < min_value && !visited[i]) {
                min_value = d[i];
                index = i;
            }
        }
        return index;
    }

    public static void dijkstra(int start) {
        d[start] = 0;
        visited[start] = true;
        for (int j = 0; j < graph.get(start).size(); j++) {
            d[graph.get(start).get(j).getIndex()] = graph.get(start).get(j).getDistance();
        }

        for (int i = 0; i < n - 1; i++) {
            int now = getSmallestNode();
            visited[now] = true;

            for (int j = 0; j < graph.get(now).size(); j++) {
                int cost = d[now] + graph.get(now).get(j).getDistance();

                if (cost < d[graph.get(now).get(j).getIndex()]) {
                    d[graph.get(now).get(j).getIndex()] = cost;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /**
         * 1. 노트 개수 n, 간선 개수 m, 시작 지점 start 입력 받는다.
         */
        String[] strings = br.readLine().split(" ");
        n = Integer.parseInt(strings[0]);
        m = Integer.parseInt(strings[1]);
        start = Integer.parseInt(br.readLine());


        /**
         * 2. graph에 n개만큼 node를 초기화
         */
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }

        /**
         * 3. a, b, c : a 노드에서 b 노드로 가는 cost가 c
         * 이걸 입력 받아서 graph에 노드와 비용 정보를 넣어준다.
         */

        for (int i = 0; i < m; i++) {
            String[] strings2 = br.readLine().split(" ");
            int a = Integer.parseInt(strings2[0]);
            int b = Integer.parseInt(strings2[1]);
            int c = Integer.parseInt(strings2[2]);
            graph.get(a).add(new Node(b, c));
        }

        /**
         * 4. int 배열 d에는 무한대의 수(10억)로 초기화해놓는다.
         */
        Arrays.fill(d, INF);

        /**
         * 5. 다익스트라의 시작 지점을 매개변수로 주어서 실행시킨다.
         */
        dijkstra(start);


        /**
         *
         */
        for (int i = 1; i <= n; i++) {
            if (d[i] == INF) {
                System.out.println("INFINITY");
            } else {
                System.out.println(d[i]);
            }
        }
    }
}
