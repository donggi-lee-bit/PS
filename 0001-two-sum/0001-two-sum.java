class Solution {
    public int[] twoSum(int[] nums, int target) {
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < nums.length; i++) {
            num1 = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                num2 = nums[j];
                int sum = num1 + num2;
                if (sum == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{num1, num2};
    }
}