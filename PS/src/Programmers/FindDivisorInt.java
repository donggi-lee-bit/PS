package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDivisorInt {

//  arr은 자연수를 담은 배열입니다.
//  정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
//  divisor는 자연수입니다.
//  array는 길이 1 이상인 배열입니다.

  public static void main(String[] args) {
    // case 1
    int[] arr = new int[]{5, 9, 7, 10};
    int divisor = 5;

    // case 2
    //int[] arr = new int[]{2, 36, 1, 3};
    //int divisor = 1;

    // case 3
    //int [] arr = new int[]{3,2,6};
    //int divisor = 10;

    solution(arr, divisor);
  }

  public static int[] solution(int[] arr, int divisor) {
    int[] answer = new int[]{};
    answer[0] = -1;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] % divisor == 0) {
        answer[i] = arr[i];
      }
    }
    return answer;
  }
}
