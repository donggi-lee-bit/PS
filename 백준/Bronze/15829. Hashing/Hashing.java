import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        Main s = new Main();
        System.out.println(s.solution(str));
    }

    public long solution(String str) {
        int prime = 1234567891;
        long r = 1;
        long answer = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int num = c - 96;
            answer += num * r % prime;
            r = r * 31 % prime;
        }

        return answer % prime;
    }

}
