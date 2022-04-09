package greedyAlgorithms;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinPlatforms {
    static class Entry {
        Integer start;
        Integer end;

        public Entry(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }

    public static int findPlatform(int[] arrival, int[] departure) {
        int count = 0;

        PriorityQueue<Entry> queue = new PriorityQueue<>(new Comparator<Entry>() {
            @Override
            public int compare(Entry o1, Entry o2) {
                return o1.start.compareTo(o2.start);
            }
        });

        for (int i = 0; i < arrival.length; i++) {
            queue.offer(new Entry(arrival[i], departure[i]));
        }

        int maxValue = -1;
        if (queue.size() > 0) {
            count = 1;
            maxValue = queue.poll().end;
        }

        while(!queue.isEmpty()) {
            Entry e = queue.poll();

            if(e.start < maxValue) {
                count++;
            }
            maxValue = Math.max(maxValue, e.end);
        }

        return count;
    }

}
