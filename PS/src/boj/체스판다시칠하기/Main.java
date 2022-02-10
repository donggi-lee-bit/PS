package boj.체스판다시칠하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    백준 1018
     */

    public static boolean[][] arr;
    public static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == 'W') {
                    arr[i][j] = true;
                } else {
                    arr[i][j] = false;
                }
            }
        }

        int n_row = n - 7;
        int m_col = m - 7;

        for (int i = 0; i < n_row; i++) {
            for (int j = 0; j < m_col; j++) {
                find(i, j);
            }
        }
        System.out.println(min);
    }

    private static void find(int x, int y) {
        int row = x + 8;
        int col = y + 8;
        int count = 0;

        boolean tf = arr[x][y];

        for (int i = x; i < row; i++) {
            for (int j = y; j < col; j++) {

                if (tf != arr[i][j]) {
                    count++;
                }

                tf = !tf;
            }
            tf = !tf;
        }

        count = Math.min(count, 64 - count);
        min = Math.min(min, count);
    }
}
