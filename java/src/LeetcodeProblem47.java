import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LeetcodeProblem47 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<List<Integer>> result = new HashSet<List<Integer>>();
        int n = nums.length;
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        permutations.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            int pSize = permutations.size();
            for (int k = 0; k < pSize; k++) {
                List<Integer> temp = permutations.get(k);
                int size = temp.size();
                for (int j = 0; j <= size; j++) {
                    List<Integer> t = new ArrayList<>(temp);
                    t.add(j, nums[i]);
                    if (t.size() == n) {
                        result.add(t);
                        continue;
                    }
                    permutations.add(t);
                }
            }
        }

        List<List<Integer>> r = new ArrayList<>();
        for(List<Integer> i: result) {
            r.add(i);
        }
        return r;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};

        List<List<Integer>> result = permuteUnique(nums);

        for(List<Integer> i: result) {
            System.out.println(i.toString());
        }
    }
}
