import java.util.HashMap;

public class LeetcodeProblem3 {
    public int lengthOfLongestSubstring(String s) {
        int startIndex = 0;
        int currLength = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hashMap.containsKey(c)) {
                startIndex = Math.max(startIndex, hashMap.get(c) + 1);
            }
            hashMap.put(c, i);
            currLength = Math.max(currLength, i - startIndex + 1);
        }

        return currLength;
    }

    public static void main(String[] args) {
        LeetcodeProblem3 l = new LeetcodeProblem3();
        System.out.println(l.lengthOfLongestSubstring("dvdf"));
        System.out.println(l.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(l.lengthOfLongestSubstring("bbbbb"));
        System.out.println(l.lengthOfLongestSubstring("pwwkew"));
    }
}
