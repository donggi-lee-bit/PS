package 인프런김태원자바.단어뒤집기;

import java.util.Scanner;

public class WordFlipping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = str.toCharArray().length - 1; j >= 0; j--) {
                sb.append(str.charAt(j));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
