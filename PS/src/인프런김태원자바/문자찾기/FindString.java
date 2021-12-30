package 인프런김태원자바.문자찾기;

import java.util.Scanner;

public class FindString {
    public static void main(String[] args) {
        /*
        한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.

        대소문자를 구분하지 않습니다.문자열의 길이는 100을 넘지 않습니다.
         */

        Scanner sc = new Scanner(System.in);
        String str = sc.next().toUpperCase();
        char findWord = sc.next().toUpperCase().charAt(0);
        int result = 0;

        for (char x : str.toCharArray()) {
            if (x == findWord) {
                result++;
            }
        }

        System.out.println(result);
    }
}
