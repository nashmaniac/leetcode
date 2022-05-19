import java.util.Arrays;

public class LeetcodeProblem329 {

    public boolean isValid(int x, int y, int row, int col) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }

    public int dfs(int[][] matrix, int x, int y, int row, int col, int[][] mem) {
        if (mem[x][y] > 0) return mem[x][y];
        int result = 0;
        int[][] directions = new int[][] {
            {1, 0}, {-1, 0}, {0, -1}, {0, 1},
        };

        for(int[] direction: directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];

            if(isValid(newX, newY, row, col) && matrix[newX][newY] > matrix[x][y]) {
                result = Math.max(result, dfs(matrix, newX, newY, row, col, mem));
            }

        }
        mem[x][y] = result+1;
        return result+1;
    }

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int answer = 0;
        int[][] mem = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(mem[i], 0);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                answer = Math.max(dfs(matrix, i, j, m, n, mem), answer);
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
        LeetcodeProblem329 l = new LeetcodeProblem329();
        System.out.println(l.longestIncreasingPath(matrix));
    }
}
