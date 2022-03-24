import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class FindKPairOfSmallestSum {
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> arr = new ArrayList<>();


        PriorityQueue<Integer> firstQueue = new PriorityQueue<>();
        PriorityQueue<Integer> secondQueue = new PriorityQueue<>();

        for (int n: nums1) {
            firstQueue.offer(n);
        }
        for(int n: nums2) {
            secondQueue.offer(n);
        }

        int i=0;
        while(i < k) {
            int first = firstQueue.poll();
            while(i<k && secondQueue.size()>0) {
                arr.add(List.of(first, secondQueue.poll()));    
                i++;
            }
        }
        return arr;
    }
}