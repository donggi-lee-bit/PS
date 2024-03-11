import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int value = map.getOrDefault(c, -1);
            if (value == -1) {
                map.put(c, i);
                answer[i] = -1;
            } else {
                int value1 = i - map.get(c);
                map.put(c, i);
                answer[i] = value1;
            }

        }

//        for (int i = 0; i < answer.length; i++) {
//            System.out.print(answer[i] + " ");
//        }

        return answer;
    }
}