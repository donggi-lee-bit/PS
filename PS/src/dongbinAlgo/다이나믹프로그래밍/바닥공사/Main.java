package dongbinAlgo.다이나믹프로그래밍.바닥공사;

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
        int[] dy = new int[1001];
        dy[1] = 1;
        dy[2] = 3;
        for (int i = 3; i <= n; i++) {
            dy[i] = (dy[i - 1] + dy[i - 2] * 2) % 796796;
        }
        return dy[n];
    }
}
