import java.util.ArrayList;
import java.util.List;

/***
 * @author shetu2153@gmail.com
 *         Problem: Pascal's Triangle
 *         Leetcode Problem Number: 118
 ****/

public class LeetcodeProblem118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(List.of(1)));
        for (int i = 1; i < numRows; i++) {
            List<Integer> newList = new ArrayList<>(List.of(1));

            for(int j=0;j<result.get(i-1).size()-1;j++) {
                newList.add(result.get(i-1).get(j)+result.get(i-1).get(j+1));
            }
            newList.add(1);

            result.add(newList);
        }

        return result;
    }
}
