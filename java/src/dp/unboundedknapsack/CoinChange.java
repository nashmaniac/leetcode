package dp.unboundedknapsack;

public class CoinChange {
    public int countChange(int[] denominations, int total) {
        int n = denominations.length;
        int[][] result = new int[n + 1][total + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < total + 1; j++) {
                if (i == 0) {
                    result[i][j] = 0;
                }
                if (j == 0) {
                    result[i][j] = 1;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < total + 1; j++) {
                if (denominations[i - 1] <= j) {
                    result[i][j] = result[i][j - denominations[i - 1]] + result[i - 1][j];
                } else {
                    result[i][j] = result[i - 1][j];
                }
            }
        }

        return result[n][total];
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int[] denominations = { 1, 2, 3 };
        System.out.println(cc.countChange(denominations, 5));
    }
}
