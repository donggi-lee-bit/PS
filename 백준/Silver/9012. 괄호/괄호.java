import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            String strings = br.readLine();
            int count = 0;

            for (int j = 0; j < strings.length(); j++) {
                char c = strings.charAt(j);

                if (count >= 0) {
                    if (c == '(') {
                        count++;
                    } else if (c == ')') count -= 1;
                } else break;
            }

            if (count == 0) {
                sb.append("YES" + "\n");
            } else {
                sb.append("NO" + "\n");
            }
        }
        System.out.println(sb);
    }
}
