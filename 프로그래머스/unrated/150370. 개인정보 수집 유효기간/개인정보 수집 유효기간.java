import java.util.*;

class Solution {
    
    public static final int YEAR = 12;
    public static final int DAY = 28;

    Map<String, Integer> map;
    int todayData;

    /**
     * 개인정보 수집 유효기간
     */

    public int[] solution(String today, String[] terms, String[] privacies) {
        todayData = convertDays(today);

        // term to Map
        map = new HashMap<>();
        for (String term : terms) {
            String[] s = term.split(" ");
            map.put(s[0], Integer.parseInt(s[1]));
        }

        // 날짜 데이터를 모두 일(day)로 치환
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] s = privacies[i].split(" ");
            int days = convertDays(s[0]);
            // 치환한 데이터로 만료 유무 판단
            if (isFire(days, s[1])) {
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

    private boolean isFire(int days, String term) {
        if (map.get(term) * DAY + days <= todayData) {
            // 만료 날짜를 더한 값이 오늘 날짜 데이터보다 작으면 만료됐다고 판단
            return true;
        }
        return false;
    }

    private int convertDays(String s) {
        String[] split = s.split("\\.");
        int y = Integer.parseInt(split[0]) - 2000;
        int m = Integer.parseInt(split[1]);
        int d = Integer.parseInt(split[2]);
        return (y * YEAR * DAY) + (m * DAY) + d;
    }
}