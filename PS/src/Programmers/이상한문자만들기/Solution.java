package Programmers.이상한문자만들기;

class Solution {
    public static String solution(String s) {

        String answer = s;
        int cnt = 1;
        for (char x : answer.toCharArray()) {

            if (x >= 97 && x <= 122 && cnt % 2 == 1) {
                x -= 32;
                cnt++;
            } else if (x >= 97 && x <= 122 && cnt % 2 == 0) {
                cnt++;
                continue;
            } else if (x == 32) {
                cnt = 1;
                continue;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("try hello world"));
    }
}
