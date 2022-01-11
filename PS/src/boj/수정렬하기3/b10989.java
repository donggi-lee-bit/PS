package boj.수정렬하기3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b10989 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = reader.readLine();
        int N = Integer.parseInt(str);

        int[] arr = new int[N];
        int[] cnt = new int[10001];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }
        reader.close();

        for (int i = 0; i < arr.length; i++) {
            int number = arr[i];
            cnt[number]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnt.length; i++) {

            if (cnt[i] != 0) {
                for (int j = 0; j < cnt[i]; j++) {
                    sb.append(i).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
