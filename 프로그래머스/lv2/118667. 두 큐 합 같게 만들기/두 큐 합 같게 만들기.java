import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        // 두 배열을 queue 에다가 옮겨담자
        LinkedList<Integer> q1 = arrToQueue(queue1);
        LinkedList<Integer> q2 = arrToQueue(queue2);

        // 두 배열의 원소 합 / 2
        long sum1 = addElement(q1);
        long sum2 = addElement(q2);

        if ((sum1 + sum2) % 2 != 0) {
            return -1;
        }

        int limit = (queue1.length + queue2.length) * 2;

        // 두 배열 비교하며 pop inset
        int answer = 0;
        while (sum1 != sum2) {
            if (answer >= limit) {
                return -1;
            }

            if (sum1 > sum2) {
                // 최대 작업 횟수를 초과하면 -1 리턴
                Integer pop = q1.pop();
                q2.add(pop);
                sum1 -= pop;
                sum2 += pop;
                answer++;
            } else if (sum1 < sum2) {
                // 최대 작업 횟수를 초과하면 -1 리턴
                Integer pop = q2.pop();
                q1.add(pop);
                sum2 -= pop;
                sum1 += pop;
                answer++;
            }
        }

        return answer;
    }

    public LinkedList<Integer> arrToQueue(int[] arr) {
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i : arr) {
            queue.add(i);
        }
        return queue;
    }

    public int addElement(Queue<Integer> queue) {
        int sum = 0;

        for (Integer value : queue) {
            sum += value;
        }

        return sum;
    }
}