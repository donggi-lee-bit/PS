package boj.팰린드롬수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /**
     * boj 1259
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                System.out.println(sb);
                break;
            } else {
                String str = Integer.toString(n);
                int count = 0;
                for (int i = 0; i < str.length() / 2; i++) {

                    if (str.charAt(i) == str.charAt(str.length() - 1 - i)) {
                        count++;
                    }
                }

                if (count == str.length() / 2) {
                    sb.append("yes").append("\n");
                } else {
                    sb.append("no").append("\n");
                }
            }
        }
    }
}
