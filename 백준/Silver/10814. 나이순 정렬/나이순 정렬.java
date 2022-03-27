import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        User[] users = new User[n];

        for (int i = 0; i < n; i++) {

            String[] strings = br.readLine().split(" ");
            int age = Integer.parseInt(strings[0]);
            String name = strings[1];
            users[i] = new User(age, name);
        }

        Arrays.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.age - o2.age;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(users[i]);
        }
        System.out.println(sb);
    }

    static class User {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return age + " " + name + "\n";
        }
    }
}