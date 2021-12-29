package dongbinAlgo.dfs;

import java.util.Scanner;
import java.util.jar.JarEntry;

public class FreezeDrinks {
    /*
    이코테 dfs 음료수 얼려먹기 문제
     */
    static int[][] arr;
    static int N;
    static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();  // 이거 진짜 안하니 실행에러가 뜬다. 버퍼 지우기
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String inputNumber = sc.nextLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = inputNumber.charAt(j) - '0';
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dfs(i, j)) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    private static boolean dfs(int i, int j) {
        if (i <= -1 || i >= N || j <= -1 || j >= M) {
            return false;
        }

        if (arr[i][j] == 0) {
            arr[i][j] = 1;

            dfs(i - 1, j);
            dfs(i, j - 1);
            dfs(i + 1, j);
            dfs(i, j + 1);
            return true;
        }
        return false;
    }
}
