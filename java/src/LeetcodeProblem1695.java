import java.util.HashMap;

public class LeetcodeProblem1695 {
    public int maximumUniqueSubarray(int[] nums) {
        int maxSum = 0, sum = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int l = 0, r = 0;
        while (r < nums.length) {
            if (hashMap.containsKey(nums[r])) {
                int m = hashMap.get(nums[r]);
                while (l <= m) {
                    sum -= nums[l];
                    l++;
                }
            }
            sum += nums[r];
            maxSum = Math.max(maxSum, sum);
            hashMap.put(nums[r], r);
            r++;
        }

        return maxSum;
    }
}
