import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            TreeMap<Integer, Integer> q = new TreeMap();
            int k = Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (command.equals("D")) {
                    if (q.isEmpty()) {
                        continue;
                    }

                    num = num == 1 ? q.lastKey() : q.firstKey();
                    if (q.put(num, q.get(num) - 1) == 1) {
                        q.remove(num);
                    }
                    
                } else {
                    q.put(num, q.getOrDefault(num, 0) + 1);
                }
            }
            // 여기서 StringBuilder에 결과 추가
            if (!q.isEmpty()) {
                // 최대값 최소값 sb에 추가
                sb.append(q.lastKey()).append("\n");
                sb.append(q.firstKey()).append("\n");
            } else {
                //비어있으면 EMPTY출력
                sb.append("EMPTY").append("\n");
            }
        }
        System.out.println(sb);
    }

}
