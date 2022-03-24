public class LeetcodeProblem977 {
    public int[] sortedSquares(int[] nums) {
        int[] arr = new int[nums.length];

        int lastIndex = nums.length - 1;
        int left = 0;
        int right = lastIndex;

        while (left <= right && lastIndex >= 0) {
            if (nums[left] * nums[left] < nums[right] * nums[right]) {
                arr[lastIndex--] = nums[right] * nums[right];
                right--;
            } else {
                arr[lastIndex--] = nums[left] * nums[left];
                left++;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { -4, -1, 0, 3, 10 };
        LeetcodeProblem977 l = new LeetcodeProblem977();
        int[] arr = l.sortedSquares(nums);
        for (int a : arr) {
            System.out.println(a);
        }
    }
}
