public class LeetcodeProblem322 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] result = new int[n + 1][amount + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < amount + 1; j++) {
                if (i == 0) {
                    result[i][j] = Integer.MAX_VALUE - 1;
                }
                if (j == 0) {
                    result[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < amount + 1; j++) {
            if (j % coins[0] == 0) {
                result[1][j] = j / coins[0];
            } else {
                result[1][j] = Integer.MAX_VALUE - 1;
            }

        }

        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (coins[i - 1] <= j) {
                    result[i][j] = Math.min(1 + result[i][j - coins[i - 1]], result[i - 1][j]);
                } else {
                    result[i][j] = result[i - 1][j];
                }
            }
        }
        if(result[n][amount] == Integer.MAX_VALUE -1) {
            return -1;
        }
        return result[n][amount];
    }
}
