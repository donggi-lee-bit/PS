import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Main s = new Main();
        s.solution(n);
    }

    public void solution(int n) {
        dfs("", n);
    }

    private void dfs(String result, int n) {
        if (result.length() == n) {
            System.out.println(result);
            System.exit(0);
        }

        for (int i = 1; i <= 3; i++) {
            if (isGoodSequence(result + i)) {
                dfs(result + i, n);
            }
        }
    }

    private boolean isGoodSequence(String s) {
        int length = s.length() / 2;
        for (int i = 1; i <= length; i++) {
            if (s.substring(s.length() - i)
                .equals(s.substring(s.length() - 2 * i, s.length() - i))) {
                return false;
            }
        }
        return true;
    }

}
