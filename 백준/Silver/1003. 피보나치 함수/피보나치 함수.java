import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int zero;
    static int one;
    static int zero_plus_one;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            fibonacci(n);
            sb.append(zero).append(" ").append(one).append("\n");
        }
        System.out.print(sb);
    }

    private static void fibonacci(int num) {
        zero = 1;
        one = 0;
        zero_plus_one = 1;

        for (int i = 0; i < num; i++) {
            zero = one;
            one = zero_plus_one;
            zero_plus_one = zero + one;
        }
    }
}
