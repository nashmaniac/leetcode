public class LeetcodeProblem283 {
    public void moveZeroes(int[] nums) {
        int startIndex = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] != 0) {
                nums[startIndex++] = nums[i];
            }
        }
        while(startIndex < nums.length) {
            nums[startIndex++] = 0; 
        }
    }
}
