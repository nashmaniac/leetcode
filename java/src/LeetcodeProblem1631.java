import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetcodeProblem1631 {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(result[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] { 0, 0, 0 });
        int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        while (!pq.isEmpty()) {
            int[] e = pq.poll();
            int dist = e[0], row = e[1], col = e[2];
            if (dist > result[row][col])
                continue;
            if (row == m - 1 && col == n - 1)
                return dist;
            for (int[] d : directions) {
                int newRow = row + d[0];
                int newCol = col + d[1];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                    int newDist = Math.max(dist, Math.abs(heights[newRow][newCol] - heights[row][col]));
                    if (newDist < result[newRow][newCol]) {
                        result[newRow][newCol] = newDist;
                        pq.offer(new int[] { newDist, newRow, newCol });
                    }
                }

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] heights = new int[][] {
                // {1,2,2},{3,8,2},{5,3,5},
                { 1, 10, 6, 7, 9, 10, 4, 9 }
        };

        LeetcodeProblem1631 l = new LeetcodeProblem1631();
        l.minimumEffortPath(heights);
    }
}
