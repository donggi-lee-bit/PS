package dongbinAlgo.다이나믹프로그래밍.개미전사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String[] strings = br.readLine().split(" ");
        int[] k = new int[n];

        for (int i = 0; i < n; i++) {
            k[i] = Integer.parseInt(strings[i]);
        }

        System.out.println(Solution(k));

    }

    private static int Solution(int[] arr) {
        int[] dy = new int[101];

        dy[0] = arr[0];
        dy[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < n; i++) {
            dy[i] = Math.max(dy[i - 1], dy[i - 2] + arr[i]);
        }
        return dy[n - 1];
    }
}
