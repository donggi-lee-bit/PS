import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Main s = new Main();
        System.out.println(s.solution(n, numbers));
    }

    public int solution(int n, int[] numbers) {
        int[] dp = new int[n];
        dp[0] = numbers[0];
        int max = numbers[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + numbers[i], numbers[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }

}
