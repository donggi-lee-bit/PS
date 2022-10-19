import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken()); // 문서의 개수 n
            int m = Integer.parseInt(st.nextToken()); // 문서가 현재 큐에 몇번쨰에 놓여있는지 m
            st = new StringTokenizer(br.readLine(), " ");
            int[] priorities = new int[n];
            for (int j = 0; j < n; j++) {
                priorities[j] = Integer.parseInt(st.nextToken());
            }
            Main s = new Main();
            System.out.println(s.solution(n, m, priorities));
        }
    }

    public int solution(int n, int target, int[] priorities) {
        LinkedList<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{i, priorities[i]});
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int[] front = queue.poll();
            boolean isMax = true;

            for (int i = 0; i < queue.size(); i++) {
                if (front[1] < queue.get(i)[1]) {
                    queue.offer(front);
                    for (int j = 0; j < i; j++) {
                        queue.offer(queue.poll());
                    }

                    isMax = false;
                    break;
                }
            }

            if (isMax == false) {
                continue;
            }

            count++;
            if (front[0] == target) {
                break;
            }
        }

        return count;
    }

}
