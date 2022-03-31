package dp.LPS;

public class LongestPalindromicSubstring {
    public int findLPSLength(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        boolean[][] result = new boolean[n][n];
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            result[i][i] = true;
            maxLength = 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1 || result[i + 1][j - 1]) {
                        result[i][j] = true;
                        maxLength = Math.max(maxLength, j - i + 1);
                    }
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        System.out.println(lps.findLPSLength("abdbca"));
        System.out.println(lps.findLPSLength("cddpd"));
        System.out.println(lps.findLPSLength("pqr"));
    }
}
