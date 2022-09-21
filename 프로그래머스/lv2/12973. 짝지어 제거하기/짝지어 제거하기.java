import java.util.Stack;

class Solution {
    public int solution(String s) {
        Stack<String> stack = new Stack<>();
        String[] split = s.split("");
        stack.push(split[0]);
        for (int i = 1; i < split.length; i++) {
            if (stack.size() >= 1) {
                if (stack.get(stack.size() - 1).equals(split[i])) {
                    stack.pop();
                } else {
                    stack.push(split[i]);
                }
            } else {
                stack.push(split[i]);
            }
        }

        if (stack.size() > 0) {
            return 0;
        } else {
            return 1;
        }
    }
}