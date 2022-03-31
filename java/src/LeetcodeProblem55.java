public class LeetcodeProblem55 {

    static Boolean[] result;

    public static boolean canJumpRecursive(int[] nums, int start, int n) {
        if(n == 0) {
            return false;
        }
        if(n == 1) {
            return true;
        }

        if(start == n - 1) {
            return true;
        }

        if(start < n-1 && nums[start] == 0) {
            return false;
        }

        if(result[n] != null) {
            return result[n];
        }

        int currentValue = nums[start];
        for(int i=0;i<currentValue;i++) {
            result[n] = canJumpRecursive(nums, start+(i+1), n);
            if(result[n]) {
                return true;
            }
        }
        return result[n];
    }

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        result = new Boolean[n];
        return canJumpRecursive(nums, 0, n);
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[] { 2, 3, 1, 1, 4 }));
        System.out.println(canJump(new int[] { 3, 2, 1, 0, 4 }));
    }
}
