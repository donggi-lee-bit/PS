class Solution {
    public int solution(int n) {
        int result = n - 1;
        for (int i = 2; i < n; i++) {
            if (n % i == 1) {
                return Math.min(i, result);
            }
        }
        return result;
    }
}