public class LeetcodeProblem189 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    public void reverse(int[] nums, int start, int end) {
        while(start<=end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public void print(int[] a) {
        for(int _a: a) {
            System.out.printf("%d ", _a);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LeetcodeProblem189 l = new LeetcodeProblem189();
        l.rotate(new int[]{1,2,3,4,5,6,7}, 3);
        l.rotate(new int[]{-1, -100, 3, 99}, 2);
    }
}
