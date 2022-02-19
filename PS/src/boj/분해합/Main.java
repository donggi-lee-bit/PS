package boj.분해합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 1; i < n; i++) {
            String[] strings = Integer.toString(i).split("");
            int copyIndex = i;

            int res = 0;
            for (String string : strings) {
                res += Integer.parseInt(string);
            }
            if (n == copyIndex + res) {
                result = copyIndex;
                break;
            }
        }
        System.out.println(result);
    }
}
