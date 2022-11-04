import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int white = 0;
    int blue = 0;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String[][] map = new String[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split(" ");
        }

        Main s = new Main();
        System.out.println(s.solution(map));
    }

    public String solution(String[][] map) {
        StringBuilder sb = new StringBuilder();

        int length = map.length;
        recursive(0, 0, map, length);

        sb.append(white).append("\n");
        sb.append(blue);
        return sb.toString();
    }

    private void recursive(int x, int y, String[][] map, int length) {
        if (length == 1) {
            if (map[x][y].equals("1")) {
                blue++;
                return;
            } else {
                white++;
                return;
            }
        }

        if (!check(x, y, map, length)) {
            recursive(x, y, map, length / 2);
            recursive(x, y + length / 2, map, length / 2);
            recursive(x + length / 2, y, map, length / 2);
            recursive(x + length / 2, y + length / 2, map, length / 2);
        } else {
            if (map[x][y].equals("1")) {
                blue++;
            } else {
                white++;
            }
        }

    }

    private boolean check(int x, int y, String[][] map, int length) {
        String firstValue = map[x][y];

        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (!firstValue.equals(map[i][j])) {
                    return false;
                }
            }
        }

        return true;
    }

}
