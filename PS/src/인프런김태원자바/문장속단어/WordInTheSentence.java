package 인프런김태원자바.문장속단어;

import java.util.Scanner;

public class WordInTheSentence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] arr = sc.nextLine().split(" ");
        String resultWord = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (resultWord.length() < arr[i].length()) {
                resultWord = arr[i];
            }
        }
        System.out.println(resultWord);
    }
}
