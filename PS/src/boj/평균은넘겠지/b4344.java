package boj.평균은넘겠지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int C = Integer.parseInt(br.readLine());

        for (int i = 0; i < C; i++) {
            String[] s = br.readLine().split("\\s");
            int num = Integer.parseInt(s[0]);

            double sum = 0;
            for (int j = 1; j < s.length; j++) {
                sum += Integer.parseInt(s[j]);
            }

            double average = sum / num;
            double count = 0;
            for (int j = 1; j < s.length; j++) {
                if (Integer.parseInt(s[j]) > average) {
                    count++;
                }
            }
            System.out.printf("%.3f%%\n", (count / num) * 100);
        }
        System.out.println(sb);
    }
}
