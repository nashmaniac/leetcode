import java.util.ArrayList;
import java.util.List;

public class LeetcodeProblem39 {
    public void findSum(int[] candidates, int target, int ind, List<Integer> tempResult, List<List<Integer>> result) {
        if(ind == candidates.length) {
            if(target == 0) {
                result.add(new ArrayList<>(tempResult));
            }
            return;
        }
        
        if(candidates[ind]<=target) {
            tempResult.add(candidates[ind]);
            findSum(candidates, target-candidates[ind], ind, tempResult, result);
            tempResult.remove(tempResult.size()-1);
        }
        findSum(candidates, target, ind+1, tempResult, result);

    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        findSum(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    public static void main(String[] args) {
        LeetcodeProblem39 c = new LeetcodeProblem39();
        System.out.println(c.combinationSum(new int[]{2, 3, 6, 7}, 7).toString());
    }
}
