import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetcodeProblem341 {
    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a
        // nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a
        // single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested
        // list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {
        Queue<Integer> queue;
        int index, size;
        List<NestedInteger> nestedList;

        public NestedIterator(List<NestedInteger> nestedList) {
            this.size = nestedList.size();
            this.index = 0;
            queue = new LinkedList<>();
            this.nestedList = nestedList;
            this.handleElement(this.index);
        }

        public void handleElement(NestedInteger i, List<Integer> arr) {
            if (i == null) {
                return;
            }
            if (i.isInteger()) {
                arr.add(i.getInteger());
            } else {
                for (NestedInteger b : i.getList()) {
                    this.handleElement(b, arr);
                }
            }
        }

        public void handleElement(int index) {
            if (index >= this.size) {
                return;
            }
            NestedInteger i = this.nestedList.get(index);
            List<Integer> temp = new ArrayList<>();
            this.handleElement(i, temp);
            if (temp.size() > 0) {
                for(Integer b: temp) {
                    queue.offer(b);
                }
                this.index++;
                return;
            }
            this.index++;
            this.handleElement(this.index);

        }

        @Override
        public Integer next() {
            int n = queue.poll();
            this.handleElement(this.index);
            return n;
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }
}
