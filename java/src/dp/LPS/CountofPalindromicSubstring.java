package dp.LPS;

public class CountofPalindromicSubstring {
    public int countPalindrome(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        boolean[][] result = new boolean[n][n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            result[i][i] = true;
            count++;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1 || result[i + 1][j - 1]) {
                        result[i][j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountofPalindromicSubstring cps = new CountofPalindromicSubstring();
        System.out.println(cps.countPalindrome("abdbca"));
        System.out.println(cps.countPalindrome("cdpdd"));
        System.out.println(cps.countPalindrome("pqr"));
    }

}
