/***
 * @author shetu2153@gmail.com
 *         Problem: Game of Life
 *         Leetcode Problem Number: 289
 ****/

public class LeetcodeProblem289 {

    public boolean isValid(int x, int y, int row, int col) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }

    public int findCount(int[][] board, int x, int y, int row, int col) {
        int count = 0;
        // up
        if (isValid(x - 1, y, row, col) && board[x - 1][y] == 1) {
            count++;
        }
        // down
        if (isValid(x + 1, y, row, col) && board[x + 1][y] == 1) {
            count++;
        }
        // left
        if (isValid(x, y - 1, row, col) && board[x][y - 1] == 1) {
            count++;
        }
        if (isValid(x - 1, y - 1, row, col) && board[x - 1][y - 1] == 1) {
            count++;
        }
        if (isValid(x + 1, y - 1, row, col) && board[x + 1][y - 1] == 1) {
            count++;
        }
        // right
        if (isValid(x, y + 1, row, col) && board[x][y + 1] == 1) {
            count++;
        }
        if (isValid(x - 1, y + 1, row, col) && board[x - 1][y + 1] == 1) {
            count++;
        }
        if (isValid(x + 1, y + 1, row, col) && board[x + 1][y + 1] == 1) {
            count++;
        }
        return count;
    }

    public void gameOfLife(int[][] board) {
        if (board.length == 0) {
            return;
        }
        int row = board.length;
        int col = board[0].length;
        // copy board
        int[][] copyBoard = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                copyBoard[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int count = findCount(copyBoard, i, j, row, col);
                if (count == 3) {
                    board[i][j] = 1;
                }
                if (count < 2 || count > 3) {
                    board[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        LeetcodeProblem289 l = new LeetcodeProblem289();
        int[][] grid = new int[][] {
                { 0, 1, 0 },
                { 0, 0, 1 },
                { 1, 1, 1 },
                { 0, 0, 0 },
        };
        l.gameOfLife(grid);

        for (int[] i : grid) {
            for (int a : i) {
                System.out.printf("%d ", a);
            }
            System.out.println();
        }

    }
}
