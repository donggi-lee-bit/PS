class Solution {
    public String solution(String s) {
        if (s.length() == 1) {
            return s;
        } else if (s.length() == 2) {
            return s;
        } else {
            if (s.length() % 2 != 0) {
                // 짝수면
                return String.valueOf(s.charAt(s.length() / 2));
            } else {
                String result = "";
                result += String.valueOf(s.charAt(s.length() / 2 - 1));
                result += String.valueOf(s.charAt(s.length() / 2));
                return result;
            }
        }
    }
}