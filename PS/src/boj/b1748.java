package Lv1;

import java.util.Scanner;

public class b1748 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int myLength = 10;
        int count = 1;
        int result = 0;

        for (int i = 1; i <= number; i++) {
            if (i == myLength) {
                myLength *= 10;
                count++;
            }
            result += count;
        }
        System.out.println(result);
    }
}
