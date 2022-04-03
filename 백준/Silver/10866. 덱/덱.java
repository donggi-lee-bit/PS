import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> arr = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            String command = st.nextToken();
            switch (command) {
                case "push_back":
                    arr.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "push_front":
                    arr.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "front":
                    if (arr.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else sb.append(arr.getFirst() + "\n");
                    break;
                case "back":
                    if (arr.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else sb.append(arr.getLast() + "\n");
                    break;
                case "size":
                    sb.append(arr.size() + "\n");
                    break;
                case "empty":
                    if (arr.isEmpty()) {
                        sb.append(1 + "\n");
                    } else sb.append(0 + "\n");
                    break;
                case "pop_front":
                    if (arr.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else sb.append(arr.removeFirst() + "\n");
                    break;
                case "pop_back":
                    if (arr.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else sb.append(arr.removeLast() + "\n");
                    break;

            }
        }
        System.out.println(sb);
    }
}
