class Solution {
    public String solution(String new_id) {
        // 1단계 : 모든 대문자를 대응되는 소문자로 치환
        // 2단계 알파벳 소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 모든 문자 제거
        String s = new_id.toLowerCase();

        String step2 = "";
        for (char c : s.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_'
                || c == '.') {
                step2 += c;
            }
        }

        // 3단계 : . . 연속으로 나오면 . 하나로 치환
        String s1 = step2.replace("..", ".");
        while (s1.contains("..")) {
            s1 = s1.replace("..", ".");
        }

        // 4단계 : .이 문자열 시작이나 끝에 있다면 제거한다
        boolean b = s1.startsWith(".");
        if (b) {
            s1 = s1.substring(1);
        }

        boolean b1 = s1.endsWith(".");
        if (b1) {
            s1 = s1.substring(0, s1.length() - 1);
        }

        // 5단계 : 빈 문자열이면 "a"를 대입
        if (s1.isEmpty()) {
            s1 = "a";
        }

        // 6단계 : 길이가 16자 이상이면, 첫 15개의 문자를 제외한 나머지 문자 제거
        if (s1.length() >= 16) {
            s1 = s1.substring(0, 15);
        }

        // 7단계 : 길이가 2 이하면, 마지막 문자를 3이 될 때까지 반복해서 끝에 붙인다.
        if (s1.length() <= 2) {
            // 마지막 문자 추출
            String lastChar = s1.substring(s1.length() - 1);

            // 길이가 3이 될 때까지 마지막 문자를 끝에 붙인다
            while (s1.length() != 3) {
                s1 += lastChar;
            }
        }

        if (s1.endsWith(".")) {
            s1 = s1.substring(0, s1.length() - 1);
        }
        return s1;
    }
}