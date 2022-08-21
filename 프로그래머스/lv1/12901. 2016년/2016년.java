class Solution {
    public String solution(int a, int b) {
        String[] days = new String[]{"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] months = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int allDays = 0;
        for (int i = 0; i < a - 1; i++) {
            allDays += months[i];
        }
        allDays += b;
        int day = allDays % 7 - 1;
        if (day == 7) {
            day = 0;
        } else if (day == -1) {
            day = 6;
        }
        return days[day];
    }
}