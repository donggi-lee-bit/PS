import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'c' && str.length() - 1 > i) {
                if (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') {
                    i++;
                }
            }

            else if ((str.charAt(i) == 'l' || str.charAt(i) == 'n') && str.length() - 1 > i) {
                if (str.charAt(i + 1) == 'j') {
                    i++;
                }
            }

            else if ((str.charAt(i) == 's' || str.charAt(i) == 'z') && str.length() - 1 > i) {
                if (str.charAt(i + 1) == '=') {
                    i++;
                }
            }

            else if (str.charAt(i) == 'd' && str.length() - 1 > i) {
                if (str.charAt(i + 1) == '-') {
                    i++;
                }

                else if (str.charAt(i + 1) == 'z' && str.length() - 2 > i && str.charAt(i + 2) == '=') {
                    i += 2;
                }
            }

            count++;
        }

        System.out.println(count);
    }

}
