package dp.lcs;

public class LongestCommonSubstring {

    public void buildTable(String s1, String s2, int n, int m, int[][] result, int maxLength) {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    result[i][j] = 1 + result[i - 1][j - 1];
                    maxLength = Math.max(result[i][j], maxLength);
                } else {
                    result[i][j] = 0;
                }
            }
        }
    }

    public int findLCSLength(String s1, String s2) {
        int maxLength = 0;
        int n = s1.length();
        int m = s2.length();
        int[][] result = new int[n + 1][m + 1];
        buildTable(s1, s2, n, m, result, maxLength);
        return maxLength;
    }


    public static void main(String[] args) {
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        System.out.println(lcs.findLCSLength("abdca", "cbda"));
        System.out.println(lcs.findLCSLength("passport", "ppsspt"));
    }
}
