package dongbinAlgo.다이나믹프로그래밍.일로만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(Solution(n));

    }

    private static int Solution(int n) {
        int[] arr = new int[30001];

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + 1;

            if (i % 2 == 0) {
                arr[i] = Math.min(arr[i], arr[i / 2] + 1);
            }

            if (i % 3 == 0) {
                arr[i] = Math.min(arr[i], arr[i / 3] + 1);
            }

            if (i % 5 == 0) {
                arr[i] = Math.min(arr[i], arr[i / 5] + 1);
            }
        }
        return arr[n];
    }
}
