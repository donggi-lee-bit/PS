package dongbinAlgo.다이나믹프로그래밍.효율적인화폐구성;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(Solution(arr, m));
    }

    private static int Solution(int[] arr, int m) {
        int target = m;
        int[] dy = new int[10001];

        return 0;
    }
}
