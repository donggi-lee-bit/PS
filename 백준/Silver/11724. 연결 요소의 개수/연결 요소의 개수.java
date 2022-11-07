import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[i][0] = u;
            arr[i][1] = v;
        }

        Main s = new Main();
        System.out.println(s.solution(n, m, arr));
    }

    public int solution(int n, int m, int[][] arr) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] checked = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < arr.length; i++) {
            int u = arr[i][0];
            int v = arr[i][1];
            list.get(u).add(v);
            list.get(v).add(u);
        }

        for (int i = 1; i <= n; i++) {
            if (!checked[i]) {
                dfs(i, list, checked);
                count++;
            }
        }
        dfs(1, list, checked);
        return count;
    }

    private void dfs(int start, List<List<Integer>> list, boolean[] checked) {
        checked[start] = true;

        List<Integer> integers = list.get(start);
        for (int i = 0; i < integers.size(); i++) {
            int value = integers.get(i);
            if (!checked[value]) {
                dfs(value, list, checked);
            }
        }
    }


}
