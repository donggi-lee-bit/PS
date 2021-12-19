package Lv1;

import java.util.Scanner;

public class b1977 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        int pow = 0;
        int result = 0;
        int minValue = 10001;
        for (int i = 1; i <= 100; i++) {
            pow = i * i;

            if (pow >= M && pow <= N) {
                result += pow;
                minValue = Math.min(minValue, pow);
            }
        }

        if (result != 0) {
            System.out.println(result);
            System.out.println(minValue);
        } else {
            System.out.println(-1);
        }
    }
}
