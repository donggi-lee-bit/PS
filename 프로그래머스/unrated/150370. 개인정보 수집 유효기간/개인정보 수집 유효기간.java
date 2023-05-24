import java.util.*;

class Solution {
    
    public static final int YEAR = 12;
    public static final int DAY = 28;

    public int[] solution(String today, String[] terms, String[] privacies) {
        // 오늘 데이터를 모두 일(day)로 치환
        int convertToday = convertDays(today);

        // term to Map
        Map<String, Integer> map = new HashMap<>();
        for (String term : terms) {
            String[] s = term.split(" ");
            map.put(s[0], Integer.parseInt(s[1]));
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] s = privacies[i].split(" ");
            // 날짜 데이터를 모두 일(day)로 치환
            int days = convertDays(s[0]);
            // 치환한 데이터로 만료 유무 판단
            if (isFire(days, convertToday, s[1], map)) {
                list.add(i + 1);
            }
        }

        // 출력
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    private boolean isFire(int days, int today, String term, Map<String, Integer> map) {
        if (map.get(term) * DAY + days <= today) {
            // 만료 날짜를 더한 값이 오늘 날짜 데이터보다 작으면 만료됐다고 판단
            return true;
        }
        return false;
    }

    private int convertDays(String s) {
        String[] split = s.split("\\.");
        // 2000년도부터 입력되기에 계산의 편의성을 위해 2000년 빼고 계산
        int y = Integer.parseInt(split[0]) - 2000;
        int m = Integer.parseInt(split[1]);
        int d = Integer.parseInt(split[2]);
        return (y * YEAR * DAY) + (m * DAY) + d;
    }
}