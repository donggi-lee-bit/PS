import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int[] lottos, int[] winNums) {
        Map<Integer, Boolean> lottoMap = new HashMap<>();
        int zeroCount = 0;
        int winCount = 0;

        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCount++;
                continue;
            }
            lottoMap.put(lotto, true);
        }

        for (int winNum : winNums) {
            if (lottoMap.containsKey(winNum)) {
                winCount++;
            }
        }

        int maxRank = 7 - winCount - zeroCount;
        int minRank = 7 - winCount;

        if (maxRank > 6) {
            maxRank = 6;
        }
        if (minRank > 6) {
            minRank = 6;
        }

        return new int[] {maxRank, minRank};
    }
}