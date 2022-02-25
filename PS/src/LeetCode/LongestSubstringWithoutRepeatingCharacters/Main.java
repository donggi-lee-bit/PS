package LeetCode.LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

class Main {
    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        Set<Character> characterSet = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (characterSet.contains(c)) {
                result = Math.max(characterSet.size(), result);
                characterSet = new HashSet<>();
            }
            characterSet.add(c);
        }
        return Math.max(characterSet.size(), result);
    }

    public static void main(String[] args) {
        String s = "abcabcbb";  // 3
        String s1 = "bbbbb";    // 1
        String s2 = "pwwkew";   // 3
        String s3 = "dvdf";     // 3


//        System.out.println(lengthOfLongestSubstring(s));
//        System.out.println(lengthOfLongestSubstring(s1));
//        System.out.println(lengthOfLongestSubstring(s2));
        System.out.println(lengthOfLongestSubstring(s3));
    }
}