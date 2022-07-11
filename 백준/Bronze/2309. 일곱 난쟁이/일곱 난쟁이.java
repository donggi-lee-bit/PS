import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 9;
        int[] arr = new int[N];
        int sum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        int num1 = 0;
        int num2 = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {

                if (sum - arr[i] - arr[j] == 100) {
                    num1 = i;
                    num2 = j;
                    break;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (i == num1 || i == num2) {
                continue;
            } else {
                sb.append(arr[i]).append("\n");
            }
        }
        System.out.println(sb);
    }
}
