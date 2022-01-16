package dongbinAlgo.이진탐색.부품찾기;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr1 = new int[N];

        for (int i = 0; i < N; i++) {
            arr1[i] = sc.nextInt();
        }
        Arrays.sort(arr1);

        int M = sc.nextInt();
        int[] arr2 = new int[M];

        for (int i = 0; i < M; i++) {
            arr2[i] = sc.nextInt();
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int result = binarySearch2(arr1, arr2[i], 0, N - 1);
            if (result == -1) {
                sb.append("no ");
            } else {
                sb.append("yes ");
            }
        }
        System.out.println(sb);
    }

    public static int binarySearch2(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return binarySearch2(arr, target, start, mid - 1);
        } else {
            return binarySearch2(arr, target, mid + 1, end);
        }
    }
}
