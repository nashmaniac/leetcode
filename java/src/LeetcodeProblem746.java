/***
 * @author shetu2153@gmail.com
 *         Problem: Min cost Climbing Stairs
 *         Leetcode Problem Number: 746
 ****/

public class LeetcodeProblem746 {
    public int minCostDPHelper(int[] cost, int start, int n) {
        if (n < start) {
            return 0;
        }
        if (n == 0) {
            return cost[0];
        }
        if (n == 1) {
            return Math.min(cost[0], cost[1]);
        }
        int n1 = minCostDPHelper(cost, start, n - 1);
        int n2 = minCostDPHelper(cost, start, n - 2);
        int currentCost = cost[n] + Math.min(n1, n2);
        // System.out.println(cost[n] + " " + currentCost + " " + cost[n-1]);
        return Math.min(currentCost, cost[n-1]);

    }

    public int minCostClimbingStairs(int[] cost) {
        return minCostDPHelper(cost, 0, cost.length - 1);
    }

    public static void main(String[] args) {
        int[][] testData = new int[][] {
                { 10, 15, 20 },
                { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 }
        };

        LeetcodeProblem746 l = new LeetcodeProblem746();

        for (int[] m : testData) {
            System.out.println(l.minCostClimbingStairs(m));
        }
    }
}
