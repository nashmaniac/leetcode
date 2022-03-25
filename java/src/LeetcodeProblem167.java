public class LeetcodeProblem167 {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length-1;
        while(start < end) {
            int currentSum = numbers[start]+numbers[end];
            if(currentSum == target) {
                return new int[] {start+1, end+1};
            } else if(currentSum < target) {
                start++;
            } else {
                end--;
            }
        }

        return new int[]{-1, -1};
    }
}
