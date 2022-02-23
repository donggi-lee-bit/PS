package boj.직각삼각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[] numberArray = new int[3];
            for (int i = 0; i < numberArray.length; i++) {
                int a = Integer.parseInt(st.nextToken());
                numberArray[i] = a;
            }
            Arrays.sort(numberArray);

            int max = numberArray[2];
            if (max == 0 && numberArray[0] == 0 && numberArray[1] == 0) {
                break;
            }

            if (Math.pow(max, 2) == Math.pow(numberArray[0], 2) + Math.pow(numberArray[1], 2)) {
                sb.append("right\n");
            } else {
                sb.append("wrong\n");
            }
        }
        System.out.println(sb);
    }
}
