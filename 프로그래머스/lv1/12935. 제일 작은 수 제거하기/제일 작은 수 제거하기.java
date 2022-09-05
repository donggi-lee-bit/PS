import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] arr) {
        if (arr.length != 1) {
            // 순회해서 제일 작은 수를 찾는다
            // 찾은 작은 수만 제외하고 배열에 담아서 반환한다.
            int min = Integer.MAX_VALUE;
            for (int i : arr) {
                min = Math.min(min, i);
            }

            List<Integer> list = new ArrayList<>();
            for (int i : arr) {
                if (min != i) {
                    list.add(i);
                }
            }

            int[] answer = new int[list.size()];
            int index = 0;
            for (Integer integer : list) {
                answer[index] = integer;
                index++;
            }
            return answer;
        } else {
            return new int[]{-1};
        }
    }
}