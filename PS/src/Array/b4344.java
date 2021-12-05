package Array;

import java.util.Scanner;

public class b4344 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    sc.nextLine();
    double sum3, sum4;

    for (int i = 0; i < num; i++) {
      int[] scoreStu = {};
      int sum = 0;
      int cnt = 0;

      // 입력 받은 점수 갯수만큼 반복
      for (int j = 0; j < scoreStu.length; j++) {
        scoreStu[j] = sc.nextInt();
      }
      // 점수를 다 더해준다
      for (int k = 1; k < scoreStu.length + 1; k++) {
        sum += scoreStu[k];
      }
      // 각 점수를 평균값과 비교해서 평균값보다 초과하는 값이면 cnt 증가
      int sum2 = sum / (scoreStu.length - 1);
      for (int kk = 1; kk < scoreStu.length; kk++) {
        if (scoreStu[kk] < sum2) {
          cnt++;
        }
      }
      sum3 = cnt / (scoreStu.length - 1);
      sum4 = Math.round(sum3 * 1000) / 1000;

    }

  }
}
