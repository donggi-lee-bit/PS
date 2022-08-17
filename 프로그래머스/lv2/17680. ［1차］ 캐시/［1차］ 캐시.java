import java.util.LinkedList;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        // 도시를 입력 순서대로 캐시 사이즈에 담는다
        // 다음 입력값을 캐시와 비교하여 캐시에 존재하는 도시이면
        // 1, 아니면 5를 answer에 더해준다
        // LRU 알고리즘을 반영하기 위해
        // 캐시에 존재하는 도시였다면
        // 해당 도시노드를 삭제하고 리스트의 맨 앞에 해당 도시노드를 추가한다
        // 캐시에 존재하지 않는 도시였다면
        // 리스트의 맨 끝 노드를 삭제하고
        // 해당 도시를 리스트 맨 앞 노드에 추가한다

        // 캐시가 다 차지 않았을 때 city 값이 캐시에 존재하는 값일 때는 answer += 1 해준다

        int answer = 0;
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        LinkedList<String> citiesList = new LinkedList<>();
        for (String city : cities) {
            String s = city.toLowerCase();
            if (citiesList.size() < cacheSize) {
                if (citiesList.contains(s)) {
                    answer += 1;
                } else {
                    answer += 5;
                }
                citiesList.addFirst(s);
            } else {
                if (citiesList.contains(s)) {
                    citiesList.remove(s);
                    answer += 1;
                    citiesList.addFirst(s);
                } else {
                    citiesList.removeLast();
                    answer += 5;
                    citiesList.addFirst(s);
                }
            }
        }
        return answer;
    }
}