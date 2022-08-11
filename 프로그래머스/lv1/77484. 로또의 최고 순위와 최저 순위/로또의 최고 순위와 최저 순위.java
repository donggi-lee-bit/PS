import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int[] lottos, int[] winNums) {
        int[] answer = new int[2];

        int winCount = 0;
        int zero = 0;

        int prize = 6;
        Map<Integer, Integer> prizeMap = new HashMap<>();
        for (int i = 1; i <= 6; i++) {
            prizeMap.put(i, prize--);
        }

        for (int i = 0; i < lottos.length; i++) {

            if (lottos[i] == 0) {
                zero++;
                continue;
            }

            for (int j = 0; j < winNums.length; j++) {
                if (lottos[i] == winNums[j]) {
                    winCount++;
                }
            }
        }

        if (zero == 6) {
            answer[0] = 1;
            answer[1] = 6;

        } else if (winCount == 0 && zero == 0) {
            answer[0] = 6;
            answer[1] = 6;
        } else {
            answer[0] = prizeMap.get(winCount + zero);
            answer[1] = prizeMap.get(winCount);
        }


        return answer;
    }
}