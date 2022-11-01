import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[][] map = new String[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split("");
        }

        Main s = new Main();
        System.out.println(s.solution(map));
    }

    public String solution(String[][] map) {
        int length = map.length;
        recursive(map, 0, 0, length);

        return sb.toString();
    }

    private void recursive(String[][] map, int x, int y, int length) {
        // 탈출 조건
        if (length == 1) {
            if (Integer.parseInt(map[x][y]) == 1) {
                sb.append("1");
                return;
            } else {
                sb.append('0');
                return;
            }
        }

        if (!checked(map, x, y, length)) {
            sb.append('(');
            recursive(map, x, y, length / 2);
            recursive(map, x, y + length / 2, length / 2);
            recursive(map, x + length / 2, y, length / 2);
            recursive(map, x + length / 2, y + length / 2, length / 2);
            sb.append(')');
        } else {
            if (Integer.parseInt(map[x][y]) == 0) {
                sb.append("0");
            } else {
                sb.append("1");
            }
        }
    }

    private boolean checked(String[][] map, int x, int y, int length) {
        int firstValue = Integer.parseInt(map[x][y]);
        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (Integer.parseInt(map[i][j]) != firstValue) {
                    return false;
                }
            }
        }
        return true;
    }

}
