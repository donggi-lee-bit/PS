import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> arr = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }

        sb.append("<");
        while (arr.size() > 0) {

            for (int i = 0; i < k - 1; i++) {
                int value = arr.poll();
                arr.offer(value);
            }

            if (arr.size() == 1) {
                sb.append(arr.poll());
            } else {
                sb.append(arr.poll()).append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}
