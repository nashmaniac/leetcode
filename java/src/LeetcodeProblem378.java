import java.util.PriorityQueue;

/***
 * @author shetu2153@gmail.com
 *         Problem: Kth Smallest Element in a Sorted Matrix
 *         Leetcode Problem Number: 378
 ****/

public class LeetcodeProblem378 {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int result = 0;

        for(int[] row: matrix) {
            for(int col: row) {
                queue.offer(col);
            }
        }
        while(k > 0) {
            result = queue.poll();
            k--;
        }
        return result;
    }
}
