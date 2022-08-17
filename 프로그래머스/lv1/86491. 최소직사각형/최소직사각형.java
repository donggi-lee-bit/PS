import java.util.Arrays;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxX = 0;
        int maxY = 0;

        for (int[] size : sizes) {
            Arrays.sort(size);

            maxX = Math.max(maxX, size[0]);
            maxY = Math.max(maxY, size[1]);
        }
        answer = maxX * maxY;
        return answer;
    }
}