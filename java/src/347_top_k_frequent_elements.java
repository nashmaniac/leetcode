import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Map.Entry;

class element {
    int intValue;
    int priority;

    public element(int intValue, int priority) {
        this.intValue = intValue;
        this.priority = priority;
    }
}

class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int[] arr = new int[k];

        // hashmap to count all the count
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0)+1);
        }

        PriorityQueue<element> pq = new PriorityQueue<element>(new Comparator<element>() {
            public int compare(element left, element right) {
                if (left.priority < right.priority) return 1;
                if (left.priority == right.priority) return 0;
                return -1;
            }
        });

        for(Entry<Integer, Integer> entry: hashMap.entrySet()) {
            pq.offer(new element(entry.getKey(), entry.getValue()));
        }

        for(int i=0;i<k;i++) {
            arr[i] = pq.poll().intValue;
        }

        return arr;
    }
}