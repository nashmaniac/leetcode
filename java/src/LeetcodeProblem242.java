/***
@author shetu2153@gmail.com
Problem: Valid Anagram
Leetcode Problem Number: 242
****/

public class LeetcodeProblem242 {
    public boolean isAnagram(String s, String t) {
        int[] sList = new int[26];
        int[] tList = new int[26];

        for(int i=0;i<s.length();i++) {
            sList[s.charAt(i)-'a']++;
        }

        for(int i=0;i<t.length();i++) {
            tList[t.charAt(i)-'a']++;
        }

        for(int i=0;i<26;i++) {
            if(sList[i] != tList[i]) {
                return false;
            }
        }

        return true;

    }
}
