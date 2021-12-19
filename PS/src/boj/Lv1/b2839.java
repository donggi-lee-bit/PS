package Lv1.Lv1;

import java.util.Scanner;

public class b2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        solve(n);
    }

    private static void solve(int n) {
        int result = 0;

        while (true) {
            if (n % 5 == 0) {
                result += n / 5;
                System.out.println(result);
                break;
            } else {
                n -= 3;
                result++;
            }
            if (n < 0) {
                result = -1;
                System.out.println(result);
                return ;
            }
        }
    }
}
