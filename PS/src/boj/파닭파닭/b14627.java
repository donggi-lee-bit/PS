package boj.파닭파닭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b14627 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strings = br.readLine().split(" ");
        int s = Integer.parseInt(strings[0]);
        int c = Integer.parseInt(strings[1]);

        int[] arr = new int[s];
        long sum = 0;
        for (int i = 0; i < s; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        Arrays.sort(arr);

        int start = 1;
        int end = (int) 1e9;
        while (start <= end) {
            int mid = (start + end) / 2;

            int cnt = 0;
            for (int i = 0; i < s; i++) {
                cnt += arr[i] / mid;
            }

            if (cnt >= c) {
                start = mid + 1;
            } else
                end = mid - 1;
        }
        System.out.println(sum - end * (long) c);
    }
}
