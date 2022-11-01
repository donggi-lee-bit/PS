import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    boolean[] visited;
    int min = Integer.MAX_VALUE;
    int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[][] arr = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            String[] s1 = br.readLine().split(" ");
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);
            arr[a][b] = 1;
            arr[b][a] = 1;
            // A, B 각각 객체를 만들어서 친구 관계 만들어준다
        }

        Main s1 = new Main();
        System.out.println(s1.solution(n, m, arr));
    }

    public int solution(int n, int m, int[][] arr) {

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            bfs(n, arr, i);
        }
        return result;
    }

    private void bfs(int n, int[][] arr, int start) {
        Queue<People> queue = new LinkedList<>();
        int count = 0;

        visited[start] = true;
        queue.offer(new People(start, 0));

        while (!queue.isEmpty()) {
            People people = queue.poll();
            count += people.value;

            for (int i = 1; i <= n; i++) {
                int num = arr[people.num][i];

                if (num == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(new People(i, people.value + 1));
                }
            }
        }

        if (min > count) {
            min = count;
            result = start;
        }
    }

}

class People {

    public int num;
    public int value;

    public People(int num, int value) {
        this.num = num;
        this.value = value;
    }
}
