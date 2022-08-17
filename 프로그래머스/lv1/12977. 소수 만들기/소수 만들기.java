class Solution {
    public int solution(int[] nums) {
        // 숫자 중 3개의 수를 더했을 때 소수의 개수
        // 서로 다른 3개의 수를 더한다
        // 소수는 약수가 1과 자기 자신만 있는 자연수
        // 5는 소수인데,
        // 5 % 5 == 0, 5 % 4 == 1, 5 % 3 == 2, 5 % 2 == 3, 5 % 1 == 0
        // 소수를 찾으려면
        //
        int answer = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int num = nums[i] + nums[j] + nums[k];
                    if (isPrime(num)) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    private boolean isPrime(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}