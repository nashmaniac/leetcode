package dp.knapsack;

import java.util.Arrays;

public class Knapsack {

    int[][] result;

    public int solveKnapsack(int[] profits, int[] weights, int capacity, int n) {
        if (n == 0 || capacity == 0) {
            return 0;
        }
        if (result[n][capacity] != -1) {
            return result[n][capacity];
        }

        if (weights[n - 1] <= capacity) {
            result[n][capacity] = Math.max(
                    profits[n - 1] + solveKnapsack(profits, weights, capacity - weights[n - 1], n - 1),
                    solveKnapsack(profits, weights, capacity, n - 1));
        } else {
            result[n][capacity] = solveKnapsack(profits, weights, capacity, n - 1);
        }
        return result[n][capacity];
    }

    public int solveKnapsackRecursive(int[] profits, int[] weights, int capacity) {
        int n = profits.length;
        result = new int[n + 1][capacity + 1];
        for (int[] r : result) {
            Arrays.fill(r, -1);
        }
        return solveKnapsack(profits, weights, capacity, n);
    }

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        int n = profits.length;
        int[][] result = new int[n + 1][capacity + 1];
        for (int[] r : result) {
            Arrays.fill(r, -1);
        }

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < capacity + 1; j++) {
                if (i == 0 || j == 0) {
                    result[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < capacity + 1; j++) {

                if (weights[i - 1] <= j) {
                    result[i][j] = Math.max(result[i - 1][j], profits[i - 1] + result[i - 1][j - weights[i - 1]]);
                } else {
                    result[i][j] = result[i - 1][j];
                }

            }
        }

        return result[n][capacity];
    }

    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] profits = { 1, 6, 10, 16 };
        int[] weights = { 1, 2, 3, 5 };
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
