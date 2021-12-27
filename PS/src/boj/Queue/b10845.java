package boj.Queue;

import java.util.LinkedList;
import java.util.Scanner;

public class b10845 {
    /*
    백준 10845번 문제
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int x = 0;
        LinkedList<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String command = sc.next();
            switch (command) {
                case "push":
                    x = sc.nextInt();
                    q.add(x);
                    break;
                case "pop":
                    if (q.isEmpty()) {
                        sb.append(-1);
                        sb.append("\n");
                    } else {
                        sb.append(q.removeFirst());
                        sb.append("\n");
                    }
                    break;
                case "empty":
                    if (q.isEmpty()) {
                        sb.append(1);
                        sb.append("\n");
                    } else {
                        sb.append(0);
                        sb.append("\n");
                    }
                    break;
                case "front":
                    if (q.isEmpty()) {
                        sb.append(-1);
                        sb.append("\n");
                    } else {
                        sb.append(q.getFirst());
                        sb.append("\n");
                    }
                    break;
                case "back":
                    if (q.isEmpty()) {
                        sb.append(-1);
                        sb.append("\n");
                    } else {
                        sb.append(q.getLast());
                        sb.append("\n");
                    }
                    break;
                case "size":
                    sb.append(q.size());
                    sb.append("\n");
                    break;
            }
        }
        System.out.println(sb);

    }
}
