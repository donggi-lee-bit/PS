package 인프런김태원자바.다이나믹프로그래밍.돌다리건너기;

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
        int[] arr = new int[n + 2];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n + 1; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }
        return arr[n + 1];
    }
}
