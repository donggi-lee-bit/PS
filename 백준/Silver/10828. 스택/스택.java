import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        List<Integer> stack = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] commands = br.readLine().split(" ");

            if (commands.length != 1) {
                int number = Integer.parseInt(commands[1]);
                stack.add(number);
            } else {

                if (commands[0].equals("top")) {

                    if (stack.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else sb.append(stack.get(stack.size() - 1) + "\n");
                }

                if (commands[0].equals("size")) {
                    sb.append(stack.size() + "\n");
                }

                if (commands[0].equals("empty")) {

                    if (stack.isEmpty()) {
                        sb.append(1 + "\n");
                    } else sb.append(0 + "\n");
                }

                if (commands[0].equals("pop")) {

                    if (stack.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else sb.append(stack.remove(stack.size() - 1) + "\n");
                }
            }
        }
        System.out.println(sb);
    }
}
