import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        Main s = new Main();
        for (int i = 0; i < t; i++) {
            String[] split = br.readLine().split(" ");
            System.out.println(s.solution(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
        }
    }

    public String solution(int prev, int current) {
        // L, 문자를 왼쪽으로 민다
        // R, 문자를 오른쪽으로
        // D, 문자값을 두 배로
        // S, 값에서 1 뺸 결과
        Queue<Integer> q = new LinkedList<>();
        boolean[] checked = new boolean[100000];
        String[] commands = new String[100000];
        Arrays.fill(commands, "");
        q.offer(prev);
        checked[prev] = true;
        while (!q.isEmpty() && !checked[current]) {
            int now = q.poll();
            int d = (now * 2) % 10000;
            int s = (now == 0) ? 9999 : now - 1;
            int l = (now % 1000) * 10 + now / 1000;
            int r = (now % 10) * 1000 + now / 10;

            if (!checked[d]) {
                checked[d] = true;
                q.add(d);
                commands[d] = commands[now] + "D";
            }

            if (!checked[s]) {
                checked[s] = true;
                q.add(s);
                commands[s] = commands[now] + "S";
            }

            if (!checked[l]) {
                checked[l] = true;
                q.add(l);
                commands[l] = commands[now] + "L";
            }

            if (!checked[r]) {
                checked[r] = true;
                q.add(r);
                commands[r] = commands[now] + "R";
            }

        }

        return commands[current];
    }
}
