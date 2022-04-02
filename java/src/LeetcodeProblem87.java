public class LeetcodeProblem87 {
    public boolean isScramble(String s1, String s2) {
        isScramble(s1, s2, 0, s1.length() - 1, "");
        return false;
    }

    public String isScramble(String s1, String s2, int i, int j, String postfix) {
        if (i > j) {
            return "";
        }
        if (i == j) {
            return s1.substring(i, j + 1) + postfix;
        }
        if((s1.substring(i, j+1)+postfix).equals(s2)) {
            return s2;
        }
        System.out.println((s1.substring(i, j+1)+postfix));
        for (int k = i; k < j; k++) {
            String firstPart = isScramble(s1, s2, i, k, s1.substring(k+1));
            String secondPart = isScramble(s1, s2, k+1, j, "");
            // System.out.println(s);
        }
        return s1.substring(i, j + 1);
    }

    public static void main(String[] args) {
        LeetcodeProblem87 l = new LeetcodeProblem87();
        System.out.println(l.isScramble("great", "rgeat"));
    }

}
