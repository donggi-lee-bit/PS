import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        arr = new int[26];
        Arrays.fill(arr, -1);
        StringBuilder sb = new StringBuilder();

        int i = 0;
        for (char x : s.toCharArray()) {

            if (duplicate(x)) {
                arr[x - 'a'] = i;
            }
            i++;
        }

        for (int j = 0; j < 26; j++) {
            sb.append(arr[j] + " ");
        }

        System.out.println(sb);
    }

    private static boolean duplicate(char x) {

        if (arr[x - 'a'] != -1) {
            return false;
        }
        return true;
    }
}
