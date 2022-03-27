import java.util.Arrays;

/***
 * @author shetu2153@gmail.com
 *         Problem: Product of Array Except Self
 *         Leetcode Problem Number: 238
 ****/

public class LeetcodeProblem238 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);

        int productLeft = 1, productRight = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = result[i]*productLeft;
            result[nums.length-1-i] = result[nums.length-1-i]*productRight;
            productLeft = productLeft*nums[i];
            productRight = productRight*nums[nums.length-1-i];
        }
        return result;

    }
}
