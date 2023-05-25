import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        // 두 배열을 queue 에다가 옮겨담자
        LinkedList<Integer> q1 = new LinkedList<>();
        LinkedList<Integer> q2 = new LinkedList<>();

        // 두 배열의 원소 합 / 2
        long sum1 = 0;
        long sum2 = 0;

        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
        }

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
}