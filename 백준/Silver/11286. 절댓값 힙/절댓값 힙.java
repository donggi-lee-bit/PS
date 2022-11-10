import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> arr = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) != Math.abs(o2)) {
                return Math.abs(o1) - Math.abs(o2);
            } else {
                return (o1 > o2) ? 1 : -1;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                arr.offer(num);
            } else {
                // 0이라면 배열에서 절대값이 가장 작은 값 출력하고 값 제거
                if (arr.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(arr.poll()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }

}
