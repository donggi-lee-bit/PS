import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);

        Main s = new Main();
        System.out.println(s.solution(n, k));
    }

    public int solution(int n, int k) {
        if (n == k) {
            return 0;
        }

        int[] checked = new int[100001];
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        checked[n] = 1;

        while (!q.isEmpty()) {
            int temp = q.poll();

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) {
                    next = temp + 1;
                } else if (i == 1) {
                    next = temp - 1;
                } else {
                    next = temp * 2;
                }

                if (next == k) {
                    return checked[temp];
                }

                if (next >= 0 && next < checked.length && checked[next] == 0) {
                    q.add(next);
                    checked[next] = checked[temp] + 1;
                }
            }
        }
        return 0;
    }

}
