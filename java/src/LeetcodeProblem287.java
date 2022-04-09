public class LeetcodeProblem287 {
    public int findDuplicate(int[] nums) {
        int n = nums.length-1;
        
        int total = 0;
        for(int a: nums) {
            total+=a;
        }

        return total-(n *(n+1))/2;
    }
}
