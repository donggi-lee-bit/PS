package dongbinAlgo;

import java.util.Scanner;

public class NumberCardGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int minValue = 10001;
            for (int j = 0; j < m; j++) {
                int card = sc.nextInt();
                minValue = Math.min(minValue, card);
            }
            result = Math.max(result, minValue);
        }
        System.out.println(result);
    }
}
