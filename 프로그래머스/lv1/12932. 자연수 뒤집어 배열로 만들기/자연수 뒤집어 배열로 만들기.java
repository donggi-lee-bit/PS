import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(long n) {
        List<Integer> arr = new ArrayList<>();
        while (n > 0) {
            arr.add(Long.valueOf(n % 10).intValue());
            n /= 10;
        }
        int[] answer = new int[arr.size()];
        int index = 0;
        for (Integer integer : arr) {
            answer[index] = integer;
            index++;
        }

        return answer;
    }
}