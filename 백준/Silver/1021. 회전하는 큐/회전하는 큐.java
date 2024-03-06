import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 원소의 개수 N
        int N = Integer.parseInt(st.nextToken());
        // 뽑아내려는 원소 개수 M
        int M = Integer.parseInt(st.nextToken());
        LinkedList<Integer> deque = new LinkedList<>();
        int[] numbers = new int[M];

        // 원소 초기화
        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        // 원소 뽑기
        for (int i = 0; i < numbers.length; i++) {
            // 덱의 절반 지점
            int half;
            if (deque.size() % 2 == 0) {
                // 짝수면 절반 지점에 -1
                half = deque.size() / 2 - 1;
            } else {
                half = deque.size() / 2;
            }

            // 원소의 위치
            int target = deque.indexOf(numbers[i]);

            // 절반 지점과 같거나 절반보다 앞이라면
            if (half >= target) {
                for (int j = 0; j < target; j++) {
                    int element = deque.pollFirst();
                    deque.addLast(element);
                    count++;
                }
            } else {
                for (int j = 0; j < deque.size() - target; j++) {
                    int element = deque.pollLast();
                    deque.addFirst(element);
                    count++;
                }
            }
            deque.pollFirst();
        }

        System.out.println(count);
    }
}