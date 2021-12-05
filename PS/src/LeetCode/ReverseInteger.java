package LeetCode;

public class ReverseInteger {
  public static long reverse(int x) {

    long res = 0;
    int minus_flag = (x > 0 ? 1 : -1);
    int absX = Math.abs(x);

    while(absX > 0 ){
      long num = absX % 10;
      absX /= 10;
      res = res * 10 + num;
      if(res > Integer.MAX_VALUE){
        return 0;
      }
    }
    res *= minus_flag;
    return res;
  }

  public static void main(String[] args) {
    int num = -1234;
    System.out.println(reverse(num));
  }

}
