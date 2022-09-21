import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        int current = n - lost.length;
        boolean[] reserveCheck = new boolean[reserve.length];
        boolean[] lostCheck = new boolean[lost.length];

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    current++;
                    reserveCheck[j] = true;
                    lostCheck[i] = true;
                }
            }
        }
        
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {

                if (!reserveCheck[j] && !lostCheck[i]) {
                    if (lost[i] == reserve[j] + 1 || lost[i] == reserve[j] - 1) {
                        reserveCheck[j] = true;
                        current++;
                        break;
                    }
                }
            }
        }
        return current;
    }
}