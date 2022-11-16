import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Main s = new Main();
        System.out.println(s.solution(n, arr));
    }

    public String solution(int n, int[] arr) {
        StringBuilder sb = new StringBuilder();

        int[] copyArr = arr.clone();
        Arrays.sort(copyArr);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for (int i = 0; i < copyArr.length; i++) {
            // key 는 원소 값, value 는 랭킹
            if (!map.containsKey(copyArr[i])) {
                map.put(copyArr[i], rank++);
            }
        }

        for (int index : arr) {
            sb.append(map.get(index)).append(" ");
        }

        return sb.toString();
    }
}
