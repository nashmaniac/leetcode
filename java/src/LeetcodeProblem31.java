import java.util.Arrays;

public class LeetcodeProblem31 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return;
        }

        int i = -1;
        for (int j = n - 1; j > 1; j--) {
            if (nums[j - 1] < nums[j]) {
                i = j - 1;
                break;
            }
        }
        if (i == -1) {
            return;
        }

        int k = n - 1;
        for (int j = i + 1; j < n; j++) {
            if (nums[j] < nums[i]) {
                k = j - 1;
                break;
            }
        }
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;

        System.out.println(Arrays.toString(nums));

        int j = n - 1;
        i++;
        while (i <= j) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        LeetcodeProblem31 l = new LeetcodeProblem31();
        l.nextPermutation(new int[] { 1, 2, 3 });
        l.nextPermutation(new int[] { 1, 5, 8, 4, 7, 6, 5, 3, 1 });
    }
}
