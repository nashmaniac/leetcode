package trees;

public class LeetcodeProblem318 {

    public int hasCommonLetter(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int result = m * n;
        if (result == 0) {
            return result;
        }

        int[] w1 = new int[26];
        int[] w2 = new int[26];

        for (int i = 0; i < m; i++) {
            w1[word1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            w2[word2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if(w1[i] > 0 && w2[i] > 0) {
                return 0;
            }
        }

        return m * n;
    }

    public int maxProduct(String[] words) {
        int result = 0;

        for(int i=0;i<words.length;i++) {
            for(int j=0;j<i+1;j++) {
                result = Math.max(result, hasCommonLetter(words[i], words[j]));
            }
        }
        return result;
    }
}
