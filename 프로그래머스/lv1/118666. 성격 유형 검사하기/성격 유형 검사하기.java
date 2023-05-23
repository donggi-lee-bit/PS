class Solution {
    public String solution(String[] survey, int[] choices) {
        int length = survey.length;
        String temp = "RTCFJMAN";
        int[] arr = new int[8];
        
        for (int i = 0; i < length; i++) {
            if (choices[i] > 4) {
                // 뒤 문자에 점수 추가
                String lastWord = survey[i].substring(survey[i].length() - 1);
                arr[temp.indexOf(lastWord)] += Math.abs(choices[i] - 4);
            } else if (choices[i] < 4) {
                // 앞 문자에 점수 추가
                String firstWord = survey[i].substring(0, 1);
                arr[temp.indexOf(firstWord)] += Math.abs(choices[i] - 4);
            }
        }

        // 1 2 3 4번 지표 계산
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < temp.length(); i += 2) {
            if (arr[i] > arr[i + 1]) {
                sb.append(temp.charAt(i));
            } else if (arr[i] < arr[i + 1]) {
                sb.append(temp.charAt(i + 1));
            } else {
                // 둘이 같으면 사전 순으로 등록
                sb.append(temp.charAt(i) < temp.charAt(i + 1) ? temp.charAt(i) : temp.charAt(i + 1));
            }

        }

        return sb.toString();
    }
}