package dongbinAlgo.realization;

import java.util.Scanner;

public class UpDownLeftRight {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String[] step = sc.nextLine().split(" ");
        int x = 1, y = 1;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        char[] moveTypes = {'L', 'R', 'U', 'D'};

        for (int i = 0; i < step.length; i++) {
            char plan = step[i].charAt(0);

            int nx = -1, ny = -1;
            for (int j = 0; j < 4; j++) {
                if (plan == moveTypes[j]) {
                    nx = x + dx[j];
                    ny = y + dx[j];
                }
            }

            if (nx < 1 || ny < 1 || nx > N || ny > N) {
                continue;
            }

            x = nx;
            y = ny;
        }

        System.out.println(x + " " + y);
    }
}
