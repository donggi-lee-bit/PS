package dongbinAlgo.이진탐색;

import java.util.Scanner;

public class Loop {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int target = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = binarySearch1(arr, target, 0, n - 1);
        if (result == -1) {
            System.out.println("찾는 데이터가 없습니다.");
        } else {
            System.out.println(result + 1);
        }
    }

    private static int binarySearch1(int[] arr, int target, int start, int end) {
        while (start <= end) {

            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
