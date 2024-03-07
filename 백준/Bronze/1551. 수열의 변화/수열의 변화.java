import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 원소의 개수 N
        int N = Integer.parseInt(st.nextToken());
        // 연산 횟수 K
        int K = Integer.parseInt(st.nextToken());
        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine(), ",");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        // K번 연산
        for (int i = 1; i <= K; i++) {
            for (int j = 0; j < N - i; j++) {
                numbers[j] = numbers[j + 1] - numbers[j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N - K; i++) {
            if (i == N - K - 1) {
                sb.append(numbers[i]);
                continue;
            }

            sb.append(numbers[i]).append(',');
        }

        System.out.println(sb);
    }
}