import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());   // 5 2
        int k = Integer.parseInt(st.nextToken());

        System.out.println(bc(n, k));
    }

    private static long bc(int n, int k) {
        if (n == k || k == 0) {
            return 1;
        } else {
            return bc(n - 1, k) + bc(n - 1, k - 1);
        }
    }

}
