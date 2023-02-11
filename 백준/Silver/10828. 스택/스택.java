import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] commands = new String[N];
        for (int i = 0; i < N; i++) {
            commands[i] = br.readLine();
        }

        Main s = new Main();
        System.out.println(s.solution(N, commands));
    }

    public String solution(int n, String[] commands) {
        StringBuilder answer = new StringBuilder();
        List<Integer> values = new ArrayList<>();
        for (String command : commands) {
            String[] s = command.split(" ");
            if (s.length > 1) {
                // 숫자가 존재하는 것 push
                values.add(Integer.parseInt(s[1]));
            } else {
                // pop, size, empty, top
                if (s[0].equals("pop")) {
                    // 가장 앞 value 지우고 출력
                    if (values.isEmpty()) {
                        answer.append(-1).append("\n");
                    } else {
                        answer.append(values.remove(values.size() - 1)).append("\n");
                    }

                } else if (s[0].equals("size")) {
                    answer.append(values.size()).append("\n");
                } else if (s[0].equals("empty")) {
                    if (values.isEmpty()) {
                        answer.append(1).append("\n");
                    } else {
                        answer.append(0).append("\n");
                    }
                } else {
                    // top 이면
                    if (values.isEmpty()) {
                        answer.append(-1).append("\n");
                    } else {
                        answer.append(values.get(values.size() - 1)).append("\n");
                    }
                }
            }
        }
        return answer.toString();
    }

}
