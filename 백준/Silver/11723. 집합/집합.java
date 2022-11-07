import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());

        boolean[] set = new boolean[21];
        boolean[] tempSet = new boolean[21];
        for (int i = 0; i < tempSet.length; i++) {
            tempSet[i] = true;
        }

        boolean[] checked = new boolean[21];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String[] split = br.readLine().split(" ");
            String command = split[0];
            int num = 0;
            if (split.length != 1) {
                num = Integer.parseInt(split[1]);
            }

            if (!checked[num] && command.equals("add")) {
                checked[num] = true;
                set[num] = true;
            } else if (command.equals("remove")) {
                if (checked[num]) {
                    set[num] = false;
                }
                checked[num] = false;
            } else if (command.equals("check")) {
                if (!checked[num]) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(1).append("\n");
                }
                // num이 있으면 1, 없으면 0 출력
//                if (!set.contains(num)) {
//                    System.out.println(0);
//                } else {
//                    System.out.println(1);
//                }
            } else if (command.equals("toggle")) {
                if (!checked[num]) {
                    checked[num] = true;
                    set[num] = true;
                } else {
                    checked[num] = false;
                    set[num] = false;
                }
                // num이 있으면 제거하고, 없으면 추가
//                if (!set.contains(num)) {
//                    set.add(num);
//                } else {
//                    set.remove(num);
//                }
            } else if (command.equals("all")) {
                // 리스트를 1부터 20 수로 바꾼다(?)
                set = tempSet;
                for (int j = 0; j < checked.length; j++) {
                    checked[j] = true;
                }
            } else if (command.equals("empty")) {
                set = new boolean[21];
                checked = new boolean[21];
            }
        }
        System.out.println(sb);
    }

}

// 11010 10101 10001 0 = 16번 출력
// 1,
// 11010
