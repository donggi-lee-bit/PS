import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

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
        Stack<Integer> stack = new Stack<>();
        for (int number : arr) {
            if (number == 0) {
                stack.pop();
            } else {
                stack.push(number);
            }
        }

        int sum = 0;
        for (Integer integer : stack) {
            sum += integer;
        }
        return sum;
    }

}
