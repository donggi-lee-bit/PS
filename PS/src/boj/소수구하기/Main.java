package boj.소수구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /*
    boj 1929 소수 구하기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = n; i <= m; i++) {

            if (isPrime(i) && i != 1) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean isPrime(int n) {

        for (int i = 2; i * i <= n; i++) {

            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
