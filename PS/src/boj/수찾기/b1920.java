package boj.수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        String[] lines = reader.readLine().split("\\s+");

        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(lines[i]);
        }

        int M = Integer.parseInt(reader.readLine());
        String[] lines2 = reader.readLine().split("\\s+");

        int[] arr2 = new int[M];
        for (int i = 0; i < arr2.length; i++) {
            int number = Integer.parseInt(lines2[i]);

            for (int j = 0; j < N; j++) {
                if (number == arr[j]) {
                    arr2[i] = 1;
                }
            }
        }
        reader.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(arr2[i]).append("\n");
        }
        System.out.println(sb);
    }
}
