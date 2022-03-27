/***
@author shetu2153@gmail.com
Problem: Generate Subset
Leetcode Problem Number: 78
****/

import java.util.ArrayList;
import java.util.List;

public class LeetcodeProblem78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            int n = result.size();
            for (int j = 0; j < n; j++) {
                List<Integer> newSubset = new ArrayList<>(result.get(j));
                newSubset.add(nums[i]);
                result.add(newSubset);
                
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetcodeProblem78 l = new LeetcodeProblem78();
        List<List<Integer>> result = l.subsets(new int[]{1, 2, 3});

        for(List<Integer> r: result) {
            for(int a: r) {
                System.out.printf("%d ", a);
            }
            System.out.println();
        }
    }
}
