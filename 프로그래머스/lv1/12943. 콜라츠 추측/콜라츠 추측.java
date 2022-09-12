class Solution {
    public int solution(int num) {
        int answer = 0;
        
        if (num == 1) {
            return 0;
        }

        long n = num;
        while (n > 1) {
            if (answer == 500) {
                return -1;
            }

            // 홀수
            if (n % 2 != 0) {
                n *= 3;
                n += 1;
            } else {
                // 짝수
                n /= 2;
            }
            answer++;
        }
        return answer;
    }
}