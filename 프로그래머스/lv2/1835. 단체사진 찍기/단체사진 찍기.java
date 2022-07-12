class Solution {
    String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
    int answer = 0;

    public int solution(int n, String[] data) {

        boolean[] visited = new boolean[8];

        dfs("", visited, data);

        return answer;
    }
    
    private void dfs(String names, boolean[] visited, String[] data) {
        // 탈출 조건문 왜 friends 는 8명인데 7일까
        if (names.length() == 8) {
            if (check(names, data)) {
                answer++;
            }
            return;
        }

        // dfs
        for (int i = 0; i < 8; i++) {
            if (!visited[i]) {
                visited[i] = true;
                String name = names + friends[i];
                dfs(name, visited, data);
                visited[i] = false;
            }
        }
    }

    private boolean check(String names, String[] data) {
        for (String d : data) {
            // parseInt 해도 되는건가? indexOf만 사용해야하나
            // 여기서 names.indexOf(d.charAt(0)) 가 무슨 역할을 하는거지
            int position1 = names.indexOf(d.charAt(0));

//            System.out.println("position1: " + position1);
//            System.out.println("names: " + names);

            int position2 = names.indexOf(d.charAt(2));
            char operation = d.charAt(3);
            int index = d.charAt(4) - '0';

            if (operation == '=') {
                // index 에 왜 1을 더해주는걸까
                // 여기서 !을 빼고 return true 를 해주면 예제와 같은 값이 나오지 않는다
                if (!(Math.abs(position1 - position2) == index + 1)) return false;
            } else if (operation == '>') {
                if (!(Math.abs(position1 - position2) > index + 1)) return false;
            } else if (operation == '<') {
                if (!(Math.abs(position1 - position2) < index + 1)) return false;
            }
        }
        return true;
    }
}