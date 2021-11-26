package LeetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSum {
  public static int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {

      for (int j = i + 1; j < nums.length; j++) {
        if (target == nums[i] + nums[j]) {
          return new int[]{i, j};
        }
      }
    }
    return new int[2];
  }


  public static void main(String[] args) {
    List<Integer> numArr = new ArrayList<Integer>();
    numArr.add(2);
    numArr.add(7);
    numArr.add(11);
    numArr.add(15);

    int[] numArr2 = new int[]{2, 7, 11, 15};
    int target = 18;
    System.out.println(Arrays.toString(twoSum(numArr2, target)));

  }
}
