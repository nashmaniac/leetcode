import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetcodeProblem1046 {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                return o2.compareTo(o1);
            }
        });

        for(int i: stones) {
            queue.offer(i);
        }

        while(queue.size() > 1) {
            int first = queue.poll();
            int second = queue.poll();
            if(first != second) {
                queue.offer(Math.abs(first-second));
            }
        }

        if(queue.size() == 1) {
            return queue.poll();
        }
        return 0;
    }
}
