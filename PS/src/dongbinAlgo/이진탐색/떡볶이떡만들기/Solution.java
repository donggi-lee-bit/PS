package dongbinAlgo.이진탐색.떡볶이떡만들기;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int start = 0;
        int end = (int) 1e9;    // 10억
        int result = 0;
        while (start <= end) {
            long total = 0;
            int mid = (start + end) / 2;

            for (int i = 0; i < n; i++) {

                if (arr[i] > mid) {
                    total += arr[i] - mid;
                }
            }
            if (total < m) {
                end = mid - 1;
            } else {
                result = mid;
                start = mid + 1;
            }
        }
        System.out.println(result);
    }
}
