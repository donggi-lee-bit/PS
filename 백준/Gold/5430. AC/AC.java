import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        Main s = new Main();
        for (int i = 0; i < t; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            System.out.println(s.solution(p, n, arr));
        }
    }

    public String solution(String p, int n, String arr) {
        StringTokenizer st = new StringTokenizer(arr, "[]");
        String[] split = new String[n];
        if (n != 0) {
            split = st.nextToken().split(",");
        }

        Deque<Integer> list = new LinkedList<>();
        for (String s : split) {
            list.offer(Integer.parseInt(s));
        }

//        int start = 0;
//        int end = n;
        boolean reverse = false;
        for (int i = 0; i < p.length(); i++) {
            char command = p.charAt(i);
            if (command == 'D') {
                if (list.size() == 0) {
                    return "error";
                }

                if (reverse) {
//                    end--;
                    list.removeLast();
                } else {
//                    start++;
                    list.removeFirst();
                }
            } else {
                // command 'R'
                if (!reverse) {
                    reverse = true;
                } else {
                    reverse = false;
                }

            }
        }

//        if (start >= end) {
//            return "error";
//        }

        List<Integer> list2 = new ArrayList<>();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            list2.add(iterator.next());
        }

        if (reverse) {
            Collections.reverse(list2);
        }

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int value : list2) {
            sb.append(value).append(",");
        }

        if (sb.length() > 2) {
            sb.deleteCharAt(sb.length() - 1);
        }

        sb.append(']');

        return sb.toString();
    }
}
