import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetcodeProblem40 {

    public void findSum(int[] candidates, int target, int ind, List<Integer> tempResult, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(tempResult));
            return;
        }

        for (int i = ind; i < candidates.length; i++) {
            if (i > ind && candidates[i] == candidates[i - 1])
                continue;
            if (candidates[i] > target)
                break;
            tempResult.add(candidates[i]);
            findSum(candidates, target - candidates[i], i + 1, tempResult, result);
            tempResult.remove(tempResult.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        findSum(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    public static void main(String[] args) {
        LeetcodeProblem40 l = new LeetcodeProblem40();
        System.out.println(l.combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8).toString());
    }
}
