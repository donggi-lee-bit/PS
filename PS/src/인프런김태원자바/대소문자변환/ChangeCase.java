package 인프런김태원자바.대소문자변환;

import java.util.Scanner;

public class ChangeCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split("");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length; i++) {
            if (str[i] == str[i].toLowerCase()) {
                sb.append(str[i].toUpperCase());
            } else if (str[i] == str[i].toUpperCase()) {
                sb.append(str[i].toLowerCase());
            }
        }
        System.out.println(sb);
    }
}
