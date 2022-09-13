import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public long solution(long n) {
        String s = String.valueOf(n);
        String[] split = s.split("");
        Arrays.sort(split, Comparator.reverseOrder());
        StringBuilder str = new StringBuilder();
        for (String s1 : split) {
            str.append(s1);
        }
        return Long.parseLong(str.toString());
    }
}