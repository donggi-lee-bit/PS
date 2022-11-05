import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    List<List<Integer>> viruses;
    boolean[] visited;
    int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Main s = new Main();
        System.out.println(s.solution(n, arr));
    }

    public int solution(int n, int[][] arr) {
        viruses = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            viruses.add(new ArrayList<>());
        }

        for (int i = 0; i < arr.length; i++) {
            int from = arr[i][0];
            int to = arr[i][1];
            List<Integer> list = viruses.get(from);
            list.add(to);

            List<Integer> list2 = viruses.get(to);
            list2.add(from);
        }

        visited = new boolean[n + 1];
        dfs(1);

        return count - 1;
    }

    private void dfs(int start) {
        visited[start] = true;
        count++;
        List<Integer> list = viruses.get(start);
        for (int i = 0; i < list.size(); i++) {
            int value = list.get(i);
            if (!visited[value]) {
                dfs(value);
            }
        }
    }
}
