package dongbinAlgo.정렬.두배열의원소교체;

import LeetCode.ReverseInteger.ReverseInteger;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];
        Integer[] arr2 = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            arr2[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        Arrays.sort(arr2, Comparator.reverseOrder());

        int result = 0;
        for (int i = 0; i < K; i++) {

            if (arr[i] < arr2[i]) {
                arr[i] = arr2[i];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
        }
        System.out.println(result);
    }
}
