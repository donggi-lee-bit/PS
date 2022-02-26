package LeetCode.LongestSubstringWithoutRepeatingCharacters;

class Main {
    public static int lengthOfLongestSubstring(String s) {
        boolean[] check = new boolean[128];
        int prev = 0;
        int wait = 0;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            int now = s.charAt(i);

            if (prev != now) {

                if (check[now] == false) {
                    check[now] = true;
                    prev = now;
                    wait++;
                } else {
                    result = Math.max(wait, result);
                    prev = now;
                }
            } else {
                result = Math.max(wait, result);
                wait = 1;
            }
        }
        return Math.max(wait, result);
    }

    public static void main(String[] args) {
        String s = "abcabcbb";  // 3
        String s1 = "bbbbb";    // 1
        String s2 = "pwwkew";   // 3
        String s3 = "dvdf";     // 3
        String s4 = " ";        // 1
        String s5 = "anviaj";   // 5

        // dvdf;

        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring(s1));
        System.out.println(lengthOfLongestSubstring(s2));
        System.out.println(lengthOfLongestSubstring(s3));
        System.out.println(lengthOfLongestSubstring(s4));
        System.out.println(lengthOfLongestSubstring(s5));
    }
}