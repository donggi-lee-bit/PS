package boj.카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    /*
    boj 2164 카드2
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        LinkedList<Integer> arr = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }

        while (true) {

            if (arr.size() == 1) {
                System.out.println(arr.getFirst());
                break;
            }

            arr.pollFirst();
            arr.addLast(arr.pollFirst());
        }
    }
}
