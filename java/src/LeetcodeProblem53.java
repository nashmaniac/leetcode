/***
@author shetu2153@gmail.com
Problem: Maximum Subarray
Leetcode Problem Number: 53
****/

public class LeetcodeProblem53 {
    public int maxSubArray(int[] nums) {
        int maxValue = Integer.MIN_VALUE;
        int currentSum = 0;
        for(int i=0;i<nums.length;i++) {
            currentSum = Math.max(currentSum+nums[i], nums[i]);
            maxValue = Math.max(maxValue, currentSum);
        }
        return maxValue;
    }
}
