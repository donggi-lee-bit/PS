import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Main m = new Main();
        System.out.println(m.solution(arr));
    }

    public String solution(int[] arr) {
        StringBuilder result = new StringBuilder();
        int[] stack = new int[arr.length];

        int index = 0;
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > start) {

                for (int j = start + 1; j <= arr[i]; j++) {
                    stack[index] = j;
                    index++;
                    result.append('+').append('\n');
                }
                start = arr[i];
            } else if (stack[index - 1] != arr[i]) {
                return "NO";
            }
            index--;
            result.append('-').append('\n');
        }
        return result.toString();
    }
}
