package HackerRank;

public class KangGaRoo {

  public static void main(String[] args) {

    int x1 = 1817;
    int v1 = 9931;
    int x2 = 8417;
    int v2 = 190;

//    x1 = 0;
//    v1 = 2;
//    x2 = 5;
//    v2 = 3;

    System.out.println(yesOrNo(x1, v1, x2, v2));
//    System.out.println(compareX);
//    System.out.println(compareV);
  }

  private static String yesOrNo(int x1, int v1, int x2, int v2) {

    if (x1 < x2) {
      if (v1 < v2) {
        return "NO";
      } else {
        if (v1 == v2) {
          return "NO";
        }
        if ((x2 - x1) % (v1 - v2) == 0) {
          return "YES";
        } else {
          return "NO";
        }
      }
    }
    else if (x1 > x2) {
      if (v1 > v2) {
        return "NO";
      } else {
        if (v1 == v2) {
          return "NO";
        }
        if ((x1 - x2) % (v2 - v1) == 0) {
          return "YES";
        } else {
          return "NO";
        }
      }
    }
    else {
      if (v1 == v2) {
        return "YES";
      } else {
        return "NO";
      }
    }
  }
}
