import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetcodeProblem90 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> arr = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        arr.add(new ArrayList<>());
        for(int i = 0;i<n;i++) {
            int size = arr.size();
            for(int j=0;j<size;j++) {
                List<Integer> oldOnes = new ArrayList<>(arr.get(j));
                oldOnes.add(nums[i]);
                if(!arr.contains(oldOnes)) {
                    arr.add(oldOnes);
                }
            }
        }
        
        return arr;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = subsetsWithDup(new int[]{1,2,2});
        System.out.println(result.toString());
    }
}
