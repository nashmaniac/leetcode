/***
@author shetu2153@gmail.com
Problem: Generate Permutations
Leetcode Problem Number: 46
****/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetcodeProblem46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<List<Integer>> permutations = new LinkedList();
        permutations.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            int n = permutations.size();
            for (int j = 0; j < n; j++) {
                List<Integer> oldPermutations = permutations.poll();
                for (int k = 0; k <= oldPermutations.size(); k++) {
                    List<Integer> newPermutations = new ArrayList<>(oldPermutations);
                    newPermutations.add(k, nums[i]);
                    if (newPermutations.size() == nums.length) {
                        result.add(newPermutations);
                    } else {
                        permutations.add(newPermutations);
                    }
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        LeetcodeProblem46 l = new LeetcodeProblem46();
        System.out.println(l.permute(new int[] { 1, 2, 3 }).toString());
    }
}
