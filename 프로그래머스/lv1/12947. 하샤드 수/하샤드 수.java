class Solution {
    public boolean solution(int x) {
        String s = String.valueOf(x);
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += Character.getNumericValue(c);
        }

        if (x % sum != 0) {
            return false;
        }
        return true;
    }
}