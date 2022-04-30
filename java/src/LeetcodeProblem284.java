import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/***
@author shetu2153@gmail.com
Problem: Peeking Iterator
Leetcode Problem Number: 284
****/

public class LeetcodeProblem284 {
    class PeekingIterator implements Iterator<Integer> {
        Queue<Integer> queue;
        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            queue = new LinkedList<>();
            while(iterator.hasNext()) {
                queue.offer(iterator.next());
            }
        }
        
        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return queue.peek();
        }
        
        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            return queue.poll();
        }
        
        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }
}
