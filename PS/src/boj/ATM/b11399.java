package boj.ATM;

import java.util.Arrays;
import java.util.Scanner;

public class b11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

//        int[] arr2= new int[N];
//
//        for (int i = 0; i < arr.length; i++) {
//            int temp = 0;
//            for (int j = 0; j < i + 1; j++) {
//                temp += arr[j];
//            }
//
//            arr2[i]=temp;
//
//        }
//
//        int result=0;
//        for(int i=0;i<arr2.length;i++){
//            result+=arr2[i];
//        }
//
//        System.out.println(result);

        int result=0;
        for(int i=0;i<arr.length;i++){
            result+=arr[i]*(arr.length-i);

        }
        System.out.println(result);
    }
}
