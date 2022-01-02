package 인프런김태원자바.특정문자뒤집기;

import java.util.Scanner;

public class FlipSpecificText {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] str = sc.next().toCharArray();
        int left = 0;
        int right = str.length - 1;

        while (left < right) {
            if (!Character.isAlphabetic(str[left])) {
                left++;
            } else if (!Character.isAlphabetic(str[right])) {
                right--;
            } else {
                char temp = str[left];
                str[left] = str[right];
                str[right] = temp;
                left++; // swap을 했을 때 left, right 포인터의 위치를 직접 이동시켜주어야한다.
                right--;
            }
        }
        System.out.println(String.valueOf(str));
    }
}
