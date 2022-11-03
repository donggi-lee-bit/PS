import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(x -> x));
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (priorityQueue.size() != 0) {
                    System.out.println(priorityQueue.poll());
                } else {
                    System.out.println(0);
                }
            } else {
                priorityQueue.offer(num);
            }
        }
    }
}
