package LeetCode.ReverseInteger;

import java.util.ArrayList;

public class ReverseInteger {

    public static int reverse(int x) {

        int minusFlag = 1;
        ArrayList<Integer> arr = new ArrayList<>();

        if (x < 0) {
            minusFlag = -1;
            x = Math.abs(x);
        }

        int i = 0;
        while (x != 0) {
            arr.add(x % 10);
            x = x / 10;
            i++;
        }

        i = 0;
        long res = 0;
        int multiplyTenCount = arr.size() - 1;
        for (int j = multiplyTenCount; j >= 0; j--) {
            long temp = 0;
            temp = arr.get(i);
            for (int k = 0; k < j; k++) {

                if (j == 0) {
                    res += arr.get(i);
                } else {
                    temp *= 10;
                }
            }
            res += temp;
            i++;
        }

        if (res * minusFlag > Integer.MAX_VALUE || res * minusFlag < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) res * minusFlag;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}
