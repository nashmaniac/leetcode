import java.util.Arrays;

/***
 * @author shetu2153@gmail.com
 *         Problem: Min cost Climbing Stairs
 *         Leetcode Problem Number: 746
 ****/

public class LeetcodeProblem746 {

    int[] result;

    public int minCostDPHelper(int[] cost, int s, int n) {
        if(s >= n) {
            return 0;
        }
        if(result[s] == -1) {
            result[s+1] = minCostDPHelper(cost, s+1, n);
            result[s+2] = minCostDPHelper(cost, s+2, n);
        }
        return cost[s] + Math.min(result[s+1], result[s+2]);
    }

    public int minCostClimbingStairs(int[] cost) {
        result = new int[cost.length+2];
        Arrays.fill(result, -1);
        return Math.min(minCostDPHelper(cost, 0, cost.length),minCostDPHelper(cost, 1, cost.length));
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
