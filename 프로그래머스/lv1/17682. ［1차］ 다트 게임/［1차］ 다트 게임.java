class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] scores = new int[3];
        int num = 0;
        int index = 0;
        // 항상 bonus는 num 뒤에 나온다. bonus 분기문이 실행되면 num, bonus 초기화..?
        for (char c : dartResult.toCharArray()) {
            if (c == 'S' || c == 'D' || c == 'T') {
                // character가 bonus면
                if (c == 'D') {
                    num *= num;
                } else if (c == 'T') {
                    num *= num * num;
                }
                scores[index] = num;
                // scores 에 점수 저장하고 num 은 다시 초기화
                index++;
                num = 0;

            } else if (c == '*' || c == '#') {
                // character가 option이면
                if (c == '#') {
                    // 해당 점수를 - 로 저장
                    scores[index - 1] = -scores[index - 1];
                } else {
                    // index == 1은 첫번째 스코어를 계산한 후 후위증감이 된 것이기 때문에 이 옵션은 첫번째 스코어에만 반영
                    if (index == 1) {
                        scores[index - 1] *= 2;
                    } else {
                        // 여기선 두 번째, 세 번째 스코어에서 동작하는 것이기에 이전 스코어에도 반영해준다
                        scores[index - 1] *= 2;
                        scores[index - 2] *= 2;
                    }
                }
            } else {
                // character는 정수다
                // 10일 땐 num이 0이 아닐 때 또 여기로 오면 원래 숫자 * 10 현재 숫자를 더한다..?
                if (num != 0) {
                    num *= 10;
                }
                num += c - '0';
            }
        }
        // scores들을 더해서 answer로 반환
        for (int score : scores) {
            answer += score;
        }

        return answer;
    }
}