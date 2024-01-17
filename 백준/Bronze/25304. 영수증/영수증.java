import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int x = Integer.parseInt(br.readLine());
    int n = Integer.parseInt(br.readLine());

    int total = 0;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      total += Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
    }

    if (total != x) {
      System.out.println("No");
    } else {
      System.out.println("Yes");
    }
  }
}
