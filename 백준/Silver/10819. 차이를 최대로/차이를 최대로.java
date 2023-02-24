import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int max = Integer.MIN_VALUE;
    int[] arr;
    boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Main s = new Main();
        System.out.println(s.solution(N, numbers));
    }

    public int solution(int n, int[] numbers) {
        arr = new int[n];
        visited = new boolean[n];
        dfs(0, n, numbers);
        return max;
    }

    private void dfs(int depth, int n, int[] numbers) {
        if (depth == n) {
            calculate();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = numbers[i];
                dfs(depth + 1, n, numbers);
                visited[i] = false;
            }

        }
    }

    private void calculate() {
        int sum = 0;
        for (int i = 1; i < arr.length; i++) {
            sum += Math.abs(arr[i] - arr[i - 1]);
        }

        if (max < sum) {
            max = sum;
        }
    }

}
