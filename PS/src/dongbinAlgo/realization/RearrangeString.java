package dongbinAlgo.realization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class RearrangeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        ArrayList<Character> charArray = new ArrayList<Character>();
        int sum = 0;

        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i))) {
                charArray.add(input.charAt(i));
            } else {
                sum += input.charAt(i) - '0';
            }
        }
        Collections.sort(charArray);
        Iterator it = charArray.iterator();

        while (it.hasNext()) {
            System.out.print(it.next());
        }

        if (sum != 0) {
            System.out.println(sum);
        }


    }
}
