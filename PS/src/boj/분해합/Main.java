package boj.분해합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 1; i < n; i++) {

            int sum = 0;
            int copy = i;
            while (copy != 0) {
                sum += copy % 10;
                copy /= 10;
            }

            if (n == sum + i) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
