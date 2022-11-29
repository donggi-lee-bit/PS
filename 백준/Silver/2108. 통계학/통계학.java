import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Main s = new Main();
        System.out.println(s.solution(n, arr));
    }

    public String solution(int n, int[] arr) {
        StringBuilder sb = new StringBuilder();
        // 산술평균 (소수점 첫째 자리에서 반올림한 값), 중앙값, 최빈값, 범위 순서대로 출력
        int sum = 0;
        int[] numbers = new int[8001];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            numbers[arr[i] + 4000]++;

            if (max < arr[i]) {
                max = arr[i];
            }

            if (min > arr[i]) {
                min = arr[i];
            }
        }

        int average = (int) Math.round((double) sum / n);

        Arrays.sort(arr);
        int center = arr[arr.length / 2];

        int mode = 9999;
        int modeMax = 0;
        boolean flag = false;
        for (int i = min + 4000; i <= max + 4000; i++) {
            if (numbers[i] > 0) {
                if (modeMax < numbers[i]) {
                    modeMax = numbers[i];
                    mode = i - 4000;
                    flag = true;
                } else if (modeMax == numbers[i] && flag) {
                    mode = i - 4000;
                    flag = false;
                }
            }
        }
        sb.append(average).append("\n");
        sb.append(center).append("\n");
        sb.append(mode).append("\n");
        sb.append(max - min);
        return sb.toString();
    }
}
