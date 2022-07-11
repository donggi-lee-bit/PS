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

        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {

                if (sum - arr[i] - arr[j] == 100) {

                    for (int k = 0; k < 9; k++) {
                        if (arr[k] == arr[i] || arr[k] == arr[j]) {
                            continue;
                        } else {
                            sb.append(arr[k]).append("\n");
                        }
                    }
                    System.out.println(sb);
                    System.exit(0);
                }
            }
        }

    }

}
