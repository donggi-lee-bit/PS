class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int num = 0;
            if (c == ' ') {
                num = 32;
            } else {
                if (c >= 'a' && c <= 'z') {
                    // 소문자다!
                    num = c + n;
                    if (num > 'z') {
                        // 소문자 범위를 넘어섰다면?
                        num -= 26;
                    }
                } else if (c >= 'A' && c <= 'Z') {
                    num = c + n;
                    if (num > 'Z') {
                        num -= 26;
                    }
                }
            }
            sb.append((char) num);
        }
        return sb.toString();
    }
}