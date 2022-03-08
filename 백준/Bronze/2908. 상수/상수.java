import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[][] arr = new int[2][2];
        arr[0][0] = Integer.parseInt(st.nextToken());
        arr[1][0] = Integer.parseInt(st.nextToken());

        String result = "";
        for (int i = 0; i < arr.length; i++) {

            while (arr[i][0] != 0) {
                int num = arr[i][0] % 10;
                result = result.concat(String.valueOf(num));
                arr[i][0] /= 10;
            }
        }

        int num1 = Integer.parseInt(result.substring(0, 3));
        int num2 = Integer.parseInt(result.substring(3, 6));

        System.out.println(Math.max(num1, num2));
    }
}
