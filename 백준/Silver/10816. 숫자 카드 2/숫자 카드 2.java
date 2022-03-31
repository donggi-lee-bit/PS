import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        cards = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            int checkNumber = Integer.parseInt(st.nextToken());

            sb.append(higherBound(checkNumber) - lowerBound(checkNumber) + " ");
        }
        System.out.println(sb);
    }

    private static int lowerBound(int checkNumber) {
        int min, max, mid;
        min = 0;
        max = cards.length - 1;
        while (min < max) {
            mid = (min + max) / 2;

            if (cards[mid] >= checkNumber) {
                max = mid;
            } else min = mid + 1;
        }
        return max;
    }

    private static int higherBound(int checkNumber) {
        int min, max, mid;
        min = 0;
        max = cards.length - 1;
        while (min < max) {
            mid = (min + max) / 2;

            if (cards[mid] > checkNumber) {
                max = mid;
            } else min = mid + 1;
        }
        if (cards[max] == checkNumber) max++;
        return max;
    }
}
