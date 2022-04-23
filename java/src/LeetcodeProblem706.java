import java.util.ArrayList;
import java.util.List;

public class LeetcodeProblem706 {
    class MyHashMap {

        int size;
        List<Integer> data;

        public MyHashMap() {
            this.size = 0;
            this.data = new ArrayList<>();
        }

        public void put(int key, int value) {
            if (key - this.size >= 1) {
                // impute will null value;
                int c = this.size;
                while (c < key) {
                    this.data.add(null);
                    this.size++;
                    c++;
                }
            }
            this.data.add(key, value);
            this.size++;
        }

        public int get(int key) {
            if (key >= this.size) {
                return -1;
            }
            Integer i = this.data.get(key);
            if (i == null) {
                return -1;
            }
            return i;
        }

        public void remove(int key) {
            if(key >= this.size) return;
            this.data.set(key, null);
        }
    }

    /**
     * Your MyHashMap object will be instantiated and called as such:
     * MyHashMap obj = new MyHashMap();
     * obj.put(key,value);
     * int param_2 = obj.get(key);
     * obj.remove(key);
     */

    public static void main(String[] args) {
        LeetcodeProblem706 l = new LeetcodeProblem706();
        MyHashMap h = l.new MyHashMap();
        h.put(1, 1);
        h.put(2, 2);
        System.out.println(h.get(1));
        System.out.println(h.get(3));
        h.put(2, 1);
        System.out.println(h.get(2));
        h.remove(2);
        System.out.println(h.get(2));
    }
}
