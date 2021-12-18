package dongbinAlgo;

import java.util.Arrays;
import java.util.Scanner;

public class ThelawOfNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = sc.nextInt();
        }

        Arrays.sort(res);
        int first = res[n - 1];
        int second = res[n - 2];

        int count = (m / (k + 1)) * k;
        count += m % (k + 1);

        int result = count * first;
        result += (m - count) * second;
        System.out.println(result);
    }
}
