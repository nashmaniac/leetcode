import java.util.ArrayList;
import java.util.List;

public class LeetcodeProblem216 {

    class Element {
        public List<Integer> list;
        public int size;
        public int sum;
        public Element(List<Integer> list, int size, int sum) {
            this.list = list;
            this.size = size;
            this.sum = sum;
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Element> combinations = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        combinations.add(new Element(new ArrayList<>(), 0, 0));
        for (int i = 0; i < 9; i++) {
            int size = combinations.size();
            for (int j = 0; j < size; j++) {
                List<Integer> temp = new ArrayList<>(combinations.get(j).list);
                temp.add(i+1);
                Element e = new Element(temp, combinations.get(j).size+1, combinations.get(j).sum+i+1);
                combinations.add(e);
                if(e.size == k && e.sum == n) {
                    result.add(e.list);
                }
            }

        }
        return result;

    }
}
