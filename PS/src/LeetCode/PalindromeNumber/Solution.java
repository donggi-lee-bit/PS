package LeetCode.PalindromeNumber;

import java.util.ArrayList;

public class Solution {

    public static boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        int copyX = x;
        long res = 0;
        ArrayList<Integer> arr = new ArrayList<>();

        int i = 0;
        while (copyX != 0) {
            arr.add(copyX % 10);
            copyX /= 10;
            i++;
        }

        i = 0;
        int multiplyTenCount = arr.size() - 1;
        for (int j = multiplyTenCount; j >= 0; j--) {
            long temp;
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

        if (res == x) {
            return true;
        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
