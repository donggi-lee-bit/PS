class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // find 최빈단어
        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 1) + 1);
        }
        
        for (int i = 0; i < banned.length; i++) {
            map.remove(banned[i]);
        }
        
        int max = Integer.MIN_VALUE;
        String answer = "";
        for (String key : map.keySet()) {
            int count = map.get(key);
            if (max < count) {
                max = count;
                answer = key;
            }
        }
        
        return answer;
    }
}