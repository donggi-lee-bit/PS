import java.util.Arrays;

import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int index = 0;
        for (int[] command : commands) {
            int from = command[0];
            int to = command[1];
            int offset = command[2] - 1;
            int[] temp = new int[to - from + 1];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = array[from - 1];
                from++;
            }
            Arrays.sort(temp);
            answer[index++] = temp[offset];
        }
        return answer;
    }
}