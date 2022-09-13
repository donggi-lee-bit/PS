class Solution {
    public long solution(long n) {
        for (int i = 1; i <= n; i++) {
            if ((long) i * i == n) {
                return (long) (i + 1) * (i + 1);
            }
        }
        return -1;
    }
}