package dp;

public class Knapsack01 {
    int[][] result;

    public int findProfit(int[] weights, int[] prices, int w, int n) {
        if (n < 0 || w == 0) {
            return 0;
        }
        if (result[n][w] != -1) {
            return result[n][w];
        }
        if (weights[n] <= w) {
            result[n][w] = Math.max(prices[n] + findProfit(weights, prices, w - weights[n], n - 1),
                    findProfit(weights, prices, w, n - 1));
        } else {
            result[n][w] = findProfit(weights, prices, w, n - 1);
        }

        return result[n][w];

    }

    public int findProfit1(int[] weights, int[] prices, int w) {
        result = new int[weights.length + 1][w + 1];
        for (int i = 0; i < weights.length + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                result[i][j] = -1;
            }
        }
        return findProfit(weights, prices, w, weights.length - 1);
    }

    public int findProfit(int[] weights, int[] prices, int w) {
        int[][] result = new int[weights.length + 1][w + 1];

        for (int i = 0; i < weights.length + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                if(i == 0 || j == 0) {
                    result[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < weights.length + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                int price = prices[i-1];
                int weight = weights[i-1];
                if(weight <= j) {
                    result[i][j] = Math.max(price+result[i-1][j-weight], result[i-1][j]);
                } else {
                    result[i][j] = result[i-1][j];
                }
                
            }
        }
        

        return result[weights.length][w];
    }

    public static void main(String[] args) {
        Knapsack01 k = new Knapsack01();
        int[] weights = new int[] {
                3, 4, 6, 5
        };
        int[] prices = new int[] {
                2, 3, 1, 4
        };

        int weight = 9;

        System.out.println(k.findProfit(weights, prices, weight));
    }
}
