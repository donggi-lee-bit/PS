package dongbinAlgo.greedy;

import java.util.Scanner;

public class NumberCardGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int result = 0;

        for (int i = 0; i < n; i++) {
            int minValue = 10001;
            for (int j = 0; j < m; j++) {
                int card = sc.nextInt();
                minValue = Math.min(minValue, card);
            }
            result = Math.max(minValue, result);
        }
        System.out.println(result);
    }
}
