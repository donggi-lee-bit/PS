import java.util.*;

class Solution {
    public int[] solution(String s) {
        /**
         * x의 모든 0을 제거
         * x의 길이를 c라고 하면, c를 2진법으로 표현한 문자열로 바꾼다
         * x = 0111010
         * s가 1이 될 때까지 이진 변환을 한다
         *
         * while 문이 s가 1이될 때까지 돈다
         * 문자에서 0을 제거하고 0의 개수 카운팅 | 이때 어쩔 수 없이 0의 개수를 파악하기 위해 문자열을 돌아야? -> replace 사용으로 해결
         * 0 제거 후의 문자열 길이 저장
         * 문자열을 이진 변환
         *
         * 이진 변환 결과로 다시 위의 연산 반복
         *
         * 최종적으로 이진 변환 횟수와 변환 과정에서 제거된 0의 개수를 배열에 담아 리턴
         */
        int[] answer = new int[2];
        int zero = 0; // 0의 개수

        int count = 0; // 이진 변환 횟수
        int length = s.length();
        while (s.length() > 1) {
            int one = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    answer[1]++;
                } else {
                    // 1이면
                    one++;
                }
            }

            s = Integer.toBinaryString(one);
            answer[0]++;
//            count = s.length() - s.replace("0", "").length();
//            length -= count; // 0을 문자열에서 제거하고 0의 개수만큼 문자열 사이즈 조정
//            s = s.replace("0", "");
//            break;
        }
        return answer;
    }
}