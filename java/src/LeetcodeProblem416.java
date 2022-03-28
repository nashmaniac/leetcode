public class LeetcodeProblem416 {

    public boolean isSubarraySumPresent(int[] nums, int sum) {
        boolean[][] result = new boolean[nums.length+1][sum+1];
        for(int i=0;i<nums.length+1;i++) {
            for(int j=0;j<sum+1;j++) {
                if(i == 0) {
                    result[i][j] = false;
                }
                if(j == 0) {
                    result[i][j] = true;
                }
            }
        }
        
        for(int i=1;i<nums.length+1;i++) {
            for(int j=1;j<sum+1;j++) {
                if(nums[i-1]<=j) {
                    result[i][j] = result[i-1][j-nums[i-1]] || result[i-1][j];
                } else {
                    result[i][j] = result[i-1][j];
                }
            }
        }
        return result[nums.length][sum];
    }

    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int i: nums) {
            total += i;
        }
        if(total % 2 != 0) {
            return false;
        }

        return isSubarraySumPresent(nums, total/2);
    }

    public static void main(String[] args) {
        LeetcodeProblem416 l = new LeetcodeProblem416();
        System.out.println(l.canPartition(new int[]{3, 3, 3, 4, 5}));
    }
    
}
