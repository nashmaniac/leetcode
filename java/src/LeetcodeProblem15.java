import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LeetcodeProblem15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        HashMap<List<Integer>, Boolean> hash = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int diff = nums[i] + nums[j] + nums[k];
                if (diff == 0) {
                    List<Integer> temp = List.of(nums[i], nums[j], nums[k]);
                    if (hash.containsKey(temp)) {
                        break;
                    }
                    result.add(temp);
                    hash.put(temp, true);
                    j++;
                    k--;
                } else if (diff < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetcodeProblem15 l = new LeetcodeProblem15();
        System.out.println(l.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }).toString());
    }
}
