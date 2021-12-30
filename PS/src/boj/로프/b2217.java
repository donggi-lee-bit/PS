package boj.로프;

import java.util.Arrays;
import java.util.Scanner;

public class b2217 {
    /*
    백준 2217번
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int max = arr[N];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i] * (N - (i - 1)));
        }

        System.out.println(max);
    }
}
