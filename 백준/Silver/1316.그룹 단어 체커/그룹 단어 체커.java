import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /*
    boj 1316
     */
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int result = 0;
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            if (check() == true) {
                result++;
            }
        }
        System.out.println(result);
    }

    private static boolean check() throws IOException {
        // 초기화하면 boolean 배열을 false로 초기화
        boolean[] check = new boolean[26];
        // happy
        String str = br.readLine();
        int prev = 0;

        for (int i = 0; i < str.length(); i++) {
            // now 에 현재 str의 Char 를 넣어준다.
            int now = str.charAt(i);

            // 중복이 아니다
            if (prev != now) {

                // check 배열에 해당 인덱스가 초기화만 된 상태 즉 값이 들어간 적이 없다.
                if (check[now - 'a'] == false) {
                    // true 를 해줌으로써 이제는 값이 들어간 적이 있다고 기록
                    check[now - 'a'] = true;
                    // 이전 값으로 현재 알파벳 아스키코드를 저장
                    prev = now;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
