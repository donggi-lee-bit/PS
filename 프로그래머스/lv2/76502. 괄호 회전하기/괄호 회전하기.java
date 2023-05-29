import java.util.Stack;

class Solution {
    public int solution(String s) {
        // x는 s의 길이
        // 일단 완전탐색으로 가보좌
        // 위 작업을 s의 길이만큼
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            // 현재 괄호 문자열이 올바른지 체크 맞으면 answer ++ 아니면 됐고
            if (isCorrectBracket(s)) {
                answer++;
            }

            // 괄호 문자열 왼쪽으로 하나씩 옮기기
            s = moveBracket(s);
        }

        return answer;
    }

    private String moveBracket(String s) {
        String firstChar = s.substring(0, 1);
        s = s.substring(1);
        s += firstChar;
        return s;
    }

    private boolean isCorrectBracket(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                // 닫는 괄호를 두가지 상황으로 처리한다
                // 닫는 괄호 앞에 여는 괄호가 존재하면 pop
                // 여는 괄호가 존재하지 않으면 올바른 괄호 문자열이 아니므로 false 반환
                if (stack.size() > 0) {
                    Character peek = stack.peek();
                    
                    if (c == ')' && peek.equals('(')) {
                        stack.pop();
                    } else if (c == ']' && peek.equals('[')) {
                        stack.pop();
                    } else if (c == '}' && peek.equals('{')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        
        if (stack.size() != 0) {
            return false;
        }
        
        return true;
    }
}