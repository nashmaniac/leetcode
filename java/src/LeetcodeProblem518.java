public class LeetcodeProblem518 {

    public int changeRecursive(int amount, int[] coins, int n) {
        if (n == 0) {
            if(amount == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if(amount == 0) {
            return 1;
        }
        if (coins[n - 1] <= amount) {
            return changeRecursive(amount - coins[n - 1], coins, n) + changeRecursive(amount, coins, n - 1);
        } else {
            return changeRecursive(amount, coins, n - 1);
        }
    }

    public int change1(int amount, int[] coins) {
        return changeRecursive(amount, coins, coins.length);
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] result = new int[n + 1][amount + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < amount + 1; j++) {
                if(i==0) {
                    result[i][j] = 0;
                }
                if(j == 0) {
                    result[i][j] = 1;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if(coins[i-1]<=j) {
                    result[i][j] = result[i][j-coins[i-1]] + result[i-1][j];
                } else {
                    result[i][j] = result[i-1][j];
                }
            }
        }

        return result[n][amount];
    }
}
