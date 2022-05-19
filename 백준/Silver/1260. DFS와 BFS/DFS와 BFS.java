import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static boolean[] visited;
	static int N;
	static boolean[][] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());	// 정점의 개수
		int M = Integer.parseInt(st.nextToken());	// 간선의 개수
		int V = Integer.parseInt(st.nextToken());	// 탐색을 시작할 정점의 번호
		// 출력 : 첫번째 줄에 dfs, 두번째 줄에 bfs
		graph = new boolean[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			graph[start][end] = true;
			graph[end][start] = true;
		}
		System.out.print(V + " ");
		dfs(V);
		visited = new boolean[N + 1];
//		System.out.println(V + " ");
		bfs(V);



	}

	private static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		visited[v] = true;
		System.out.println();

		while (!q.isEmpty()) {
			v = q.poll();
			System.out.print(v + " ");

			for (int i = 1; i <= N; i++) {
				if (graph[v][i] && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}

	}

	private static void dfs(int v) {
		visited[v] = true;

		for (int i = 1; i <= N; i++) {

			// v 에서 출발했을 때 간선이 있고 방문하지 않았으면 방문 표시를 하고 해당 노드를 기록 한 후 그 노드로부터 다시 출발
			if (graph[v][i] && !visited[i]) {
				System.out.print(i + " ");
				dfs(i);
			}
		}
	}

}
