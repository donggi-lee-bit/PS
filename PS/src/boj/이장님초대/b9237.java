package boj.이장님초대;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class b9237 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer[] arr = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // Integer 타입 배열로 선언하여 Collections.reverseOrder() 메서드로 내림차순 배열로 바꿔주었다
        Arrays.sort(arr, Collections.reverseOrder());

        int j = N - 1;
        for (int i = 0; i < N; i++) {
            arr[i] = arr[i] - j;
            j--;
        }

        // 결과를 다시 내림차순 정렬
        Arrays.sort(arr, Collections.reverseOrder());
        int result = arr[0] + N + 1;
        System.out.println(result);
    }
}
