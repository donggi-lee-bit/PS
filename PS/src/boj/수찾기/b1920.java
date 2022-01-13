package boj.수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        String[] lines = reader.readLine().split("\\s+");

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(lines[i]);
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(reader.readLine());

        String[] lines2 = reader.readLine().split("\\s+");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {

            if (Arrays.binarySearch(arr, Integer.parseInt(lines2[i])) >= 0) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}
