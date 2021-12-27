package dongbinAlgo.realization;

import java.util.Scanner;

public class LuckyStraight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] arr = sc.nextLine().split("");
        int arrLength = arr.length;
        int result = 0;
        int i;

        for (i = 0; i < arrLength / 2; i++) {
            result += Integer.parseInt(arr[i]);
        }

        for (int j = i; j < arrLength; j++) {
            result -= Integer.parseInt(arr[j]);
        }

        if (result == 0) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
}
