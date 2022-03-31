package dp.lcs;

public class LongestCommonSubsequence {

    public void buildTable(String s1, String s2, int n, int m, int[][] result) {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    result[i][j] = 1 + result[i - 1][j - 1];
                } else {
                    result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]);
                }
            }
        }
    }

    public int findLCSLength(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] result = new int[n + 1][m + 1];
        buildTable(s1, s2, n, m, result);
        return result[n][m];
    }

    public String printSubSequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] result = new int[n + 1][m + 1];
        buildTable(s1, s2, n, m, result);

        int i = n;
        int j = m;

        String subSequeString = "";
        while(i > 0 && j > 0) {
            if(s1.charAt(i-1) == s2.charAt(j-1)) {
                subSequeString = String.valueOf(s1.charAt(i-1)) + subSequeString;
                i--;
                j--;
            } else {
                int upValue = result[i-1][j];
                int sideValue = result[i][j-1];
                if(upValue > sideValue) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        return subSequeString;
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println(lcs.findLCSLength("abdca", "cbda"));
        System.out.println(lcs.printSubSequence("abdca", "cbda"));
        
        System.out.println(lcs.findLCSLength("passport", "ppsspt"));
        System.out.println(lcs.printSubSequence("passport", "ppsspt"));

    }
}
