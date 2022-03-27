import java.util.Arrays;

/***
 * @author shetu2153@gmail.com
 *         Problem: House Robber
 *         Leetcode Problem Number: 198
 ****/

public class LeetcodeProblem198 {
    int[] result;

    public int robRecursive(int[] nums, int n) {
        if (n < 0) {
            return 0;
        }
        if (result[n] != -1) {
            return result[n];
        } else {
            result[n-2] = robRecursive(nums, n-2);
            result[n-1] = robRecursive(nums, n-1);
            return Math.max(nums[n] + result[n-2], result[n-1]);
        }
    }

    public int robMemoized(int[] nums) {
        result = new int[nums.length];
        Arrays.fill(result, -1);
        return robRecursive(nums, nums.length - 1);
    }

    public int rob(int[] nums) {
        int[] result = new int[nums.length + 1];
        result[0] = 0;
        for (int i = 1; i < result.length; i++) {
            if (i < 2) {
                result[i] = nums[i - 1];
            } else {
                result[i] = Math.max(nums[i - 1] + result[i - 2], result[i - 1]);
            }
        }

        return result[nums.length];
    }

    public static void main(String[] args) {
        LeetcodeProblem198 l = new LeetcodeProblem198();
        System.out.println(l.robMemoized(new int[] { 1, 2, 3, 1 }));
    }
}
