package boj.파닭파닭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b14627 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] strings = reader.readLine().split(" ");
        int S = Integer.parseInt(strings[0]);
        int C = Integer.parseInt(strings[1]);

        int[] arr = new int[S];
        for (int i = 0; i < S; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }

        Arrays.sort(arr);

    }
}
