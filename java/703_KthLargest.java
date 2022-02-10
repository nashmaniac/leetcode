import java.util.PriorityQueue;

class KthLargest {
    private PriorityQueue<Integer> queue;
    private int k;
    public KthLargest(int k, int[]nums) {
        queue = new PriorityQueue<>();
        this.k = k;
        for (int num: nums) {
            queue.offer(num);
        }

        while(queue.size() > k) {
            queue.poll();
        }
        
    }

    public int add(int val) {
        queue.offer(val);
        while(queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }
}
