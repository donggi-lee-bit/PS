package Lv1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class b1292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        List<Integer> arr = new ArrayList<>();

        int num = 1;
        int count = 0;
        for (int i = 0; i < 1000; i++) {
            arr.add(num);
            count++;

            if (num == count) {
                num++;
                count = 0;
            }
        }
        int result = 0;
        for (int i = A - 1; i <= B - 1; i++) {
            result += arr.get(i);
        }
        System.out.println(result);
    }
}
