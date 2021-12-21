package dongbinAlgo.greedy;

import java.util.Scanner;

public class UntilNumberOne {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int result = 0;

        while (n >= k) {
            while (n % k != 0) {
                n -= 1;
                result++;
            }
            n /= k;
            result++;
        }

        while (n > 1) {
            n -= 1;
            result++;
        }
        System.out.println(result);
    }
}
