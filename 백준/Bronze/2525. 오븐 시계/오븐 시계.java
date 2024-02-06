import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);

        int cookingMinutes = Integer.parseInt(br.readLine());

        hour += (minute + cookingMinutes) / 60;
        minute = (minute + cookingMinutes) % 60;

        if (hour >= 24) {
            hour -= 24;
        }

        System.out.println(hour + " " + minute);
    }

}
