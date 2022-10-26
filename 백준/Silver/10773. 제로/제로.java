import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Main s = new Main();
        System.out.println(s.solution(arr));
    }

    public int solution(int[] arr) {
        int top = 0;
        int[] arr2 = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr2[top] = 0;
                top -= 1;
            } else {
                top += 1;
                arr2[top] = arr[i];
            }
        }

        int sum = 0;
        for (int i : arr2) {
            sum += i;
        }
        return sum;
    }

}
