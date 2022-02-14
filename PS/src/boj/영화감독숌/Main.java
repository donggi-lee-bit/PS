package boj.영화감독숌;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
    boj 1436 영화감독 숌
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int num = 666;
        int count = 1;

        while (count != n) {
            num++;
            if (String.valueOf(num).contains("666")) {
                count++;
            }
        }
        System.out.println(num);
    }
}
