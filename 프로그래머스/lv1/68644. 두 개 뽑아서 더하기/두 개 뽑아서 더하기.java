import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int[] numbers) {

        Arrays.sort(numbers);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        int[] answer = new int[set.size()];
        int index = 0;
        for (Integer i : set) {
            answer[index] = i;
            index++;
        }
        Arrays.sort(answer);
        return answer;
    }
}