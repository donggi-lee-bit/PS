import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        Main s = new Main();
        System.out.println(s.solution(input));

    }

    public int solution(String input) {
        // 괄호를 통해 식의 값을 최소로 만드는 프로그램
        String[] tokens = input.split("-");
        int sum = Integer.MAX_VALUE;
        for (String token : tokens) {
            int temp = 0;
            String[] split = token.split("\\+");
            for (int i = 0; i < split.length; i++) {
                temp += Integer.parseInt(split[i]);
            }
            if (sum == Integer.MAX_VALUE) {
                sum = temp;
            } else {
                sum -= temp;
            }
        }

        return sum;
    }

}
