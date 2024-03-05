import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] str = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            str[i] = numbers[i] + "";
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(final String o1, final String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        String result = "";
        for (int i = 0; i < str.length; i++) {
            result += str[i];
        }
        
        if (result.startsWith("0")) {
            return "0";
        }

        return result;
    }
}