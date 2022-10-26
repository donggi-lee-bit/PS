import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int A = Integer.parseInt(split[0]); // A미터
        int B = Integer.parseInt(split[1]); // 자는동안 B미터 미끄러진다
        int V = Integer.parseInt(split[2]); // 나무 막대 V미터

        Main s = new Main();
        System.out.println(s.solution(A, B, V));
    }

    public int solution(int up, int down, int length) {
        int day = (length - down) / (up - down);

        if ((length - down) % (up - down) != 0) {
            day++;
        }
        return day;
    }

}
