class Solution {
    public String solution(String new_id) {
        // 1단계 : 모든 대문자를 대응되는 소문자로 치환
        String step1 = new_id.toLowerCase();

        // 2단계 알파벳 소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 모든 문자 제거
        String step2 = "";
        for (char c : step1.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_'
                || c == '.') {
                step2 += c;
            }
        }

        // 3단계 : . . 연속으로 나오면 . 하나로 치환
        String step3 = step2.replace("..", ".");
        while (step3.contains("..")) {
            step3 = step3.replace("..", ".");
        }

        // 4단계 : .이 문자열 시작이나 끝에 있다면 제거한다
        String step4 = step3;
        if (step4.startsWith(".")) {
            step4 = step4.substring(1);
        }

        if (step4.endsWith(".")) {
            step4 = step4.substring(0, step4.length() - 1);
        }

        // 5단계 : 빈 문자열이면 "a"를 대입
        String step5 = step4;
        if (step5.isEmpty()) {
            step5 = "a";
        }

        // 6단계 : 길이가 16자 이상이면, 첫 15개의 문자를 제외한 나머지 문자 제거
        // 문자 제거한 후 문자의 맨 뒤가 다시 "." 으로 끝난다면 "." 제거
        String step6 = step5;
        if (step6.length() >= 16) {
            step6 = step6.substring(0, 15);

            if (step6.endsWith(".")) {
                step6 = step6.substring(0, step6.length() - 1);
            }
        }

        // 7단계 : 길이가 2 이하면, 마지막 문자를 3이 될 때까지 반복해서 끝에 붙인다.
        String step7 = step6;
        if (step7.length() <= 2) {
            // 마지막 문자 추출
            String lastChar = step7.substring(step7.length() - 1);

            // 길이가 3이 될 때까지 마지막 문자를 끝에 붙인다
            while (step7.length() != 3) {
                step7 += lastChar;
            }
        }

        return step7;
    }
}