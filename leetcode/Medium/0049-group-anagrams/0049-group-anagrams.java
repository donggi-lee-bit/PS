class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            
            String key = String.valueOf(c);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            
            map.put(key, list);
        }
        
        List<List<String>> answer = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            answer.add(entry.getValue());
        }
        
        return answer;
    }
}