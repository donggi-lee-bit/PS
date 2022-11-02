import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        String[] poketmons = new String[n + 1];
        for (int i = 1; i <= n; i++) {
            // 도감에 수록할 포켓몬
            poketmons[i] = br.readLine();
        }

        String[] problems = new String[m];
        for (int i = 0; i < m; i++) {
            // 문제
            problems[i] = br.readLine();
        }

        Main s = new Main();
        System.out.println(s.solution(poketmons, problems));
    }

    public String solution(String[] poketmons, String[] problems) {
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> poketmonMap = new HashMap<>();
        int num = 0;
        for (String poketmon : poketmons) {
            poketmonMap.put(poketmon, num++);
        }

        for (String problem : problems) {
            if (isDigit(problem)) {
                // 숫자면
                String poketmon = poketmons[Integer.parseInt(problem)];
                sb.append(poketmon).append("\n");
            } else {
                // 포켓몬 이름이 문제로 나왔을 때
                int number = poketmonMap.get(problem);
                sb.append(number).append("\n");
            }
        }
        return sb.toString();
    }

    private boolean isDigit(String problem) {
        try {
            Integer.parseInt(problem);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
