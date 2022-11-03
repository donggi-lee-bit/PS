import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        StringTokenizer st;
        Map<String, String> passwordMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            passwordMap.put(st.nextToken(), st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            String id = br.readLine();
            System.out.println(passwordMap.get(id));
        }
    }

}
