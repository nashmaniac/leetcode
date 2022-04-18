public class LeetcodeProblem152 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        Integer[] result = new Integer[n+1];
        return maxProduct(nums, n, 1, result);
    }

    public int maxProduct(int[] nums, int curIndex, int cur, Integer[] result) {
        if(curIndex == 0) {
            return cur;
        }
        if(result[curIndex] != null) {
            return result[curIndex];
        }
        result[curIndex] = Math.max(maxProduct(nums, curIndex-1, cur*nums[curIndex-1], result), maxProduct(nums, curIndex-1, 1, result));
        return result[curIndex];
    }
}
