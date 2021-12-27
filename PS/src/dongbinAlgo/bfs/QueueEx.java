package dongbinAlgo.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class QueueEx {
    public static void main(String[] args) {
        Queue q = new LinkedList();
        q.add(5);
        q.add(2);
        q.add(3);
        q.add(7);
        q.poll();
        q.add(1);
        q.add(4);
        q.poll();

        System.out.println(q);
    }
}
