import java.util.LinkedList;
import java.util.Queue;

public class LeetcodeProblem1091 {

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1)
            return -1;

        int n = grid.length;

        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[] { 0, 0, 1 });

        int[][] directions = new int[][] {
                { -1, -1 },
                { -1, 0 },
                { -1, 1 },
                { 0, -1 },
                { 0, 1 },
                { 1, -1 },
                { 1, 0 },
                { 1, 1 },
        };

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int[] points = queue.poll();
                if (points[0] == n - 1 && points[1] == n - 1) {
                    return points[2];
                }

                for (int[] direction : directions) {
                    int row = points[0] + direction[0];
                    int col = points[1] + direction[1];

                    if (row >= 0 && row < n && col >= 0 && col < n && grid[row][col] == 0) {
                        queue.add(new int[]{row, col, points[2]+1});
                        grid[row][col] = 1;
                    }
                }
            }
        }
        return -1;
    }
}
