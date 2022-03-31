package dp.unboundedknapsack;

class CoinCountChange {

    public int countChange(int[] denominations, int total) {
        int n = denominations.length;
        int[][] result = new int[n + 1][total + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < total + 1; j++) {
                if (i == 0) {
                    result[i][j] = Integer.MAX_VALUE - 1;
                } 
                if(j == 0) {
                    result[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < total + 1; j++) {
            if (j % denominations[0] == 0) {
                result[1][j] = j / denominations[0];
            } else {
                result[1][j] = 0;
            }
        }

        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < total + 1; j++) {
                if(denominations[i-1] <= j) {
                    result[i][j] = Math.min(result[i-1][j], 1+result[i][j-denominations[i-1]]);
                } else {
                    result[i][j] = result[i-1][j];
                }
            }
        }
        return result[n][total];
    }

    public static void main(String[] args) {
        CoinCountChange cc = new CoinCountChange();
        int[] denominations = { 1, 2, 3 };
        System.out.println(cc.countChange(denominations, 5));
        System.out.println(cc.countChange(denominations, 11));
        System.out.println(cc.countChange(denominations, 7));
        denominations = new int[] { 3, 5 };
        System.out.println(cc.countChange(denominations, 7));
    }
}
