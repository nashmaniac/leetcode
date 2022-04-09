import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LeetcodeProblem56 {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> arrList = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for(int[] a: intervals) {
            if(arrList.isEmpty()) {
                arrList.add(List.of(a[0], a[1]));
            } else {
                if(arrList.get(arrList.size()-1).get(1) > a[0]) {
                    arrList.get(arrList.size()-1).set(1, Math.max(a[1], arrList.get(arrList.size()-1).get(1)));
                } else {
                    arrList.add(List.of(a[0], a[1]));
                }
            }
        }

        return (int[][]) arrList.toArray();
    }
}
