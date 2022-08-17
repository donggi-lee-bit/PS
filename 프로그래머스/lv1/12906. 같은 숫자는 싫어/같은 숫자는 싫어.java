import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        // 배열에 담을 때 연속된 숫자이면 연속된 숫자는 배열에 담지 않는다
        // 연속된 숫자인 걸 알고자 할 때는
        // boolean 배열을 0부터 9까지의 정수 사이즈로
        // 연속된 숫자를 체크하고 숫자가 바뀔 때 boolean 배열을 다시 초기화 해준다
        // 처음 들어갈 숫자는 무조건 중복 수가 아닐 것이다
        // 이전 수를 갱신하는 변수를 루프 바깥에 두고 수를 갱신한다
        //
        // arr 루프를 1번 인덱스부터 시작
        // i 와 i - 1 을 비교해서 같으면 추가 X
        // 다르면 추가
        List<Integer> list = new ArrayList<>();
        if (arr.length == 1) {
            return new int[]{arr[0]};
        } else if (arr.length > 1) {
            list.add(arr[0]);
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] != arr[i - 1]) {
                    list.add(arr[i]);
                }
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}