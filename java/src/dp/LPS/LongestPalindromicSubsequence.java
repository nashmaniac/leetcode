package dp.LPS;

import java.util.Arrays;

public class LongestPalindromicSubsequence {
    int[][] result;

    public int findLPSLengthR(String s) {
        result = new int[s.length()][s.length()];
        for (int[] r : result) {
            Arrays.fill(r, -1);
        }
        return findLPSLengthRecursive(s, 0, s.length() - 1);
    }

    public int findLPSLength(String s) {
        int n = s.length();
        result = new int[n][n];
        for (int i = 0; i < n; i++) {
            result[i][i] = 1;
        }
        for (int start = s.length() - 1; start >= 0; start--) {
            for (int end = start + 1; end < n; end++) {
                if (s.charAt(start) == s.charAt(end)) {
                    if (end - start == 1) {
                        result[start][end] = 2;
                    } else {
                        result[start][end] = 2 + result[start + 1][end - 1];
                    }
                } else {
                    result[start][end] = Math.max(result[start + 1][end], result[start][end - 1]);
                }
            }
        }
        return result[0][n - 1];
    }

    public int findLPSLengthRecursive(String s, int start, int end) {
        if (start > end) {
            return 0;
        }

        if (start == end) {
            return 1;
        }

        if (result[start][end] != -1) {
            return result[start][end];
        }

        if (s.charAt(start) == s.charAt(end)) {
            result[start][end] = 2 + findLPSLengthRecursive(s, start + 1, end - 1);
        } else {
            result[start][end] = Math.max(
                    findLPSLengthRecursive(s, start + 1, end),
                    findLPSLengthRecursive(s, start, end - 1));
        }
        return result[start][end];
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
        System.out.println(lps.findLPSLength("abdbca"));
        System.out.println(lps.findLPSLength("cddpd"));
        System.out.println(lps.findLPSLength("pqr"));
    }
}
