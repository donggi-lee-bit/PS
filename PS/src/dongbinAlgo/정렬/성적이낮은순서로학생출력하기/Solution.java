package dongbinAlgo.정렬.성적이낮은순서로학생출력하기;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Integer[] arr = new Integer[N];
        String[] strings = new String[N];
        for (int i = 0; i < N; i++) {
            strings[i] = sc.next();
            arr[i] = sc.nextInt();
        }

    }
}
