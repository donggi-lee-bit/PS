import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] cards = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        int max = 0;

        for (int i = 0; i < cards.length; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < cards.length - 2; i++) {
            int firstCard = cards[i];
            int secondCard;
            int thirdCard;

            for (int j = i + 1; j < cards.length - 1; j++) {
                secondCard = cards[j];
                for (int k = j + 1; k < cards.length; k++) {
                    thirdCard = cards[k];
                    int total = firstCard + secondCard + thirdCard;

                    if (total <= m) {
                        max = Math.max(total, max);
                    }
                }
            }
        }
        System.out.println(max);
    }
}
