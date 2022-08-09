import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, HashSet<String>> map = new HashMap<>();
        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            map.put(id_list[i], new HashSet<>());
            indexMap.put(id_list[i], i);
        }

        for (String s : report) {
            String[] split = s.split(" ");
            String from = split[0];
            String to = split[1];
            HashSet<String> set = map.get(to);
            set.add(from);
            map.put(to, set);
        }

        for (String s : map.keySet()) {
            HashSet<String> set = map.get(s);
            if (set.size() >= k) {
                for (String s1 : set) {
                    answer[indexMap.get(s1)]++;
                }
            }
        }
        return answer;
    }
}