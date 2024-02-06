import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] list = input.split(" ");

        long result = 0;
        for (final String s : list) {
            result += Long.parseLong(s);
        }

        System.out.println(result);
    }

}
