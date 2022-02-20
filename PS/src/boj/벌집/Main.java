package boj.벌집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
    boj 2292 벌집
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int result = 2;
        int six = 6;

        if (n == 1) {
            System.out.println(1);
        } else {
            for (int i = 2; i <= n; i++) {

                if (i - 2 == six) {
                    result++;
                    six += 6 * (result - 1);
                }
            }
            System.out.println(result);
        }

    }
}
