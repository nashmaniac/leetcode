import java.util.ArrayList;
import java.util.List;

public class LeetcodeProblem1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int m = grid.length;
        if (m == 0) {
            return result;
        }
        int n = grid[0].length;
        int totalCount = m * n;
        int[] temp = new int[totalCount];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[((i * n + j) + k) % totalCount] = grid[i][j];
            }
        }

        for (int i = 0; i < totalCount; i++) {
            int row = i/n;
            int col = i%n;
            if(result.size()<=row) {
                result.add(new ArrayList<>());
            }
            result.get(row).add(col, temp[i]);
        }

        return result;
    }
}
