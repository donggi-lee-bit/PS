package dongbinAlgo.realization;

import java.util.Scanner;

public class Time {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int count = 0;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 60; j++) {
                for (int kk = 0; kk < 60; kk++) {
                    if (i / 10 == k || i % 10 == k || j / 10 == k || j % 10 == k || kk / 10 == k || kk % 10 == k) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
