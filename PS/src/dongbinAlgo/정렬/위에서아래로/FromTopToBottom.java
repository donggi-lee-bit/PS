package dongbinAlgo.정렬.위에서아래로;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FromTopToBottom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Integer[] arr = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, Comparator.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }
}
