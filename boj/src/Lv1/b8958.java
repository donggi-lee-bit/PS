package Lv1;

import java.util.Scanner;

public class b8958 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int num = sc.nextInt();
    sc.nextLine();
    int cnt;
    int sum;
    int[] sumPrint = new int[num];

    String[] arr = new String[num];

    for (int i = 0; i < num; i++) {
      String str = sc.nextLine();
      arr[i] = str;
      char[] arrWord = new char[str.length()];
      sum = 0;
      cnt = 0;

      for (int j = 0; j < arrWord.length; j++) {
        arrWord[j] = str.charAt(j);

        if (arrWord[j] == 'O') {
          cnt++;
          sum += cnt;
        } else if (arrWord[j] == 'X') {
          cnt = 0;
        }
        sumPrint[i] = sum;
      }
    }
    for (int i = 0; i < sumPrint.length; i++) {
      System.out.println(sumPrint[i]);
    }
  }
}
