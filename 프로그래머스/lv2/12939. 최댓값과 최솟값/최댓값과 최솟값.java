import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String[] split = s.split(" ");
        int[] ints = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            ints[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(ints);
        int min = ints[0];
        int max = ints[ints.length - 1];

        StringBuilder answer = new StringBuilder();
        answer.append(min).append(" ").append(max);
        return answer.toString();
    }
}