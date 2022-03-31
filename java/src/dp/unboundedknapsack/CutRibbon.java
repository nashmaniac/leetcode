package dp.unboundedknapsack;

class CutRibbon {
    public int countRibbonPieces(int[] ribbonLengths, int total) {
        int n = ribbonLengths.length;
        int[][] result = new int[n][total + 1];
        for (int i = 0; i < n; i++) {
            result[i][0] = 0;
        }

        for(int j=0;j<total+1;j++) {
            if(j%ribbonLengths[0] == 0) {
                result[0][j] = j/ribbonLengths[0];
            } else {
                result[0][j] = 0;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < total + 1; j++) {
                if (ribbonLengths[i]<=j) {
                    result[i][j] = Math.max(1+result[i][j-ribbonLengths[i]], result[i-1][j]);
                } else {
                    result[i][j] = result[i-1][j];
                }
            }
        }
        return result[n-1][total];
    }

    public static void main(String[] args) {
        CutRibbon cr = new CutRibbon();
        int[] ribbonLengths = { 2, 3, 5 };
        // System.out.println(cr.countRibbonPieces(ribbonLengths, 5));
        // ribbonLengths = new int[] { 2, 3 };
        // System.out.println(cr.countRibbonPieces(ribbonLengths, 7));
        // ribbonLengths = new int[] { 3, 5, 7 };
        // System.out.println(cr.countRibbonPieces(ribbonLengths, 13));
        ribbonLengths = new int[] { 3, 5 };
        System.out.println(cr.countRibbonPieces(ribbonLengths, 7));
    }
}
