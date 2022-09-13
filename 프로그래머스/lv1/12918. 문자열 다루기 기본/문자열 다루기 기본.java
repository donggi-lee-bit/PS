class Solution {
    public boolean solution(String s) {
        if (s.length() == 4 || s.length() == 6) {
            String str = s.toLowerCase();
            for (char c : str.toCharArray()) {
                if (c >= 'a' && c <= 'z') {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}