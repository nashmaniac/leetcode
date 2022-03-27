import java.util.Comparator;
import java.util.PriorityQueue;

/***
 * @author shetu2153@gmail.com
 *         Problem: Kth Largest Element in an array
 *         Leetcode Problem Number: 215
 ****/

public class LeetcodeProblem215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                return o2.compareTo(o1);
            }
        });

        for (int i : nums) {
            queue.offer(i);
        }
        int result = 0;
        while (k > 0) {
            result = queue.poll();
            k--;
        }
        return result;
    }
}
