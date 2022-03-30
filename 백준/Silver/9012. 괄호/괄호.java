import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            int check = 0;
            for (char x : s.toCharArray()) {

                if (check >= 0) {

                    if (x == '(') {
                        check++;
                    } else if (x == ')') {
                        check -= 1;
                    }
                } else break;
            }

            if (check == 0) {
                sb.append("YES" + "\n");
            } else {
                sb.append("NO" + "\n");
            }
        }
        System.out.println(sb);
    }
}
