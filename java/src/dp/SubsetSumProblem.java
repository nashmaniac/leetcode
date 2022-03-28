package dp;

public class SubsetSumProblem {

    Boolean[][] result;

    public boolean isPresent(int[] nums, int target, int n) {
        if(n <= 0) {
            if(target == 0) {
                return true;
            } else {
                return false;
            }
        }
        if(target == 0) {
            return true;
        }
        if(result[n][target] != null){
            return result[n][target];
        }
        if(nums[n-1] <= target) {
            result[n][target] = isPresent(nums, target-nums[n-1], n-1) || isPresent(nums, target, n-1);
        } else {
            result[n][target] = isPresent(nums, target, n-1);
        }
        return result[n][target];

    }

    public boolean isPresent1(int[] nums, int target) {
        result = new Boolean[nums.length+1][target+1];
        return isPresent(nums, target, nums.length);
    }

    public boolean isPresent(int[] nums, int target) {
        Boolean[][] result = new Boolean[nums.length+1][target+1];
        for(int i=0;i<nums.length+1;i++) {
            for(int j=0;j<target+1;j++) {
                if(i == 0) {
                    result[i][j] = false;
                }
                if(j == 0) {
                    result[i][j] = true;
                }
            }
        }

        for(int i=1;i<nums.length+1;i++) {
            for(int j=1;j<target+1;j++) {
                if(nums[i-1] <= j) {
                    result[i][j] = result[i-1][j-nums[i-1]] || result[i-1][j];
                } else {
                    result[i][j] = result[i-1][j];
                }
            }
        }
        return result[nums.length][target];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
            12, 1, 61, 5, 9, 2,
        };
        int target = 24;

        SubsetSumProblem s = new SubsetSumProblem();
        System.out.println(s.isPresent(nums, target));
    }
}
