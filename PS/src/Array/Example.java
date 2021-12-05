package Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Example {

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(1);
    list.add(2);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    // true를 반환하는 모든 요소를 포함하는 스트림을 반환
    List<Integer> results = list.stream()
        .filter(i -> i > 0)
        .collect(Collectors.toList());
    // 중복제거
    List<Integer> filtered = list.stream()
        .distinct()
        .collect(Collectors.toList());
    // 중복제거
    Set<Integer> filtered2 = list.stream()
        .collect(Collectors.toSet());

    // 매핑 Integer Stream 을 String Stream 으로 변환한다는데 아직 잘 모르겠는데.
    List<String> strList = list.stream()
        .map(i -> Integer.toString(i))
        .collect(Collectors.toList());
    // 인수로 전달받은 프리디케이트가 하나라도 true면, true 반환
    boolean a = list.stream()
        .anyMatch(i -> i > 4);

    boolean b = list.stream()
        .anyMatch(i -> i > 5);
    //true를 반환하는 요소가 존재하지 않는 경우, true
    boolean c = list.stream()
        .noneMatch(i -> i > 4);

    boolean d = list.stream()
        .noneMatch(i -> i > 5);
    //findFirst, stream의 첫번째 요소를 찾아 반환.
    int num = list.stream()
        .findFirst()
        .get();
    /* stream의 데이터를 변환하지 않고, 더하거나 빼는 등의 연산을 수행하여 하나의 값으로 만든다.
    Optional<Integer> sum = list.reduce(0, (re, du) -> {
          System.out.println("re : " + a + "\n b : " + du + "\n");
        });

     */

    System.out.println("results : " + results);
    System.out.println("filtered : " + filtered);
    System.out.println("filtered2 : " + filtered2);
    System.out.println("strList : " + strList);
    System.out.println("anyMatch a : " + a);
    System.out.println("anyMatch b : " + b);
    System.out.println("noneMatch c : " + c);
    System.out.println("noneMatch d : " + d);
    System.out.println("findFirst num : " + num);
    //System.out.println("reducing sum : " + sum);
  }

}

/*
Enumeration, 열거형이라고 불리며, 서로 연관된 상수들의 집합을 말한다.
자바에서 final static String, int 같은 기본자료형의 값을 Enum으로 대체하여 사용할 수 있다.

 */