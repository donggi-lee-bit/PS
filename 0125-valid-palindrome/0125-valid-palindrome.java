class Solution {
    public boolean isPalindrome(String s) {
        s = s.trim().toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z' || c >= '0' && c <= '9') {
                sb.append(c);
            }
        }

        return sb.toString().equals(sb.reverse().toString());
    }
}