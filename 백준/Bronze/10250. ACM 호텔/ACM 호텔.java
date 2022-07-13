import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int h = Integer.parseInt(st.nextToken());   // 호텔의 층 수 6
            int w = Integer.parseInt(st.nextToken());   // 각 층의 방 수 12
            int n = Integer.parseInt(st.nextToken());   // 몇 번째 손님 10

            /**
             * dfs 가 아니라 수학 문제였다. 문제를 보고 어떻게 풀어야하는지에 대한 감이 잘 잡히지 않는다.
             */

            int floor = 0;
            int ho = 0;
            if (n % h == 0) {
                floor = h * 100;
                ho = n / h;
            } else {
                floor = n % h * 100;
                ho = n / h + 1;
            }
            System.out.println(floor + ho);
        }
    }

}
