class Solution {
    
    private int maxPalinLength = 0;
    private int startIndex = 0;
    
    public String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        
        for (int i = 0; i < length; i++) {
            checkPalin(i, i, s);
            checkPalin(i, i + 1, s);
        }
        
        return s.substring(startIndex, maxPalinLength + startIndex);
    }
    
    private void checkPalin(int left, int right, String s) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        int palinLength = right - left - 1;
        
        if (maxPalinLength < palinLength) {
            maxPalinLength = palinLength;
            startIndex = left + 1;
        }
    }
}