package boj.RGB거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int RED = 0;
    private static final int GREEN = 1;
    private static final int BLUE = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][RED] = Integer.parseInt(st.nextToken());
            arr[i][GREEN] = Integer.parseInt(st.nextToken());
            arr[i][BLUE] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            arr[i][RED] += Math.min(arr[i - 1][GREEN], arr[i - 1][BLUE]);
            arr[i][GREEN] += Math.min(arr[i - 1][RED], arr[i - 1][BLUE]);
            arr[i][BLUE] += Math.min(arr[i - 1][RED], arr[i - 1][GREEN]);
        }
        System.out.println(Math.min(Math.min(arr[n - 1][RED], arr[n - 1][GREEN]), arr[n - 1][BLUE]));
    }
}
