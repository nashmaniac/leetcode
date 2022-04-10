public class LeetcodeProblem36 {

    public boolean valid(char[][] board, int row, int col) {
        // System.out.printf("Row %d Col %d\n", row, col);
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] != '.' && i != col && (board[row][i] == board[row][col]))
                return false;
            if (board[i][col] != '.' && i != row && board[i][col] == board[row][col])
                return false;

            int m = 3 * (row / 3) + i / 3;
            int n = 3 * (col / 3) + i % 3;
            // System.out.printf("Row %d %d\n", row, i);
            // System.out.printf("Col %d %d\n", i, col);
            // System.out.printf("SubMatrix%d %d\n", m, n);
            if (board[m][n] != '.' && m != row && n != col &&board[m][n] == board[row][col])
                return false;
        }
        // System.out.println("-------------------------------");
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    if (!valid(board, i, j)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        LeetcodeProblem36 l = new LeetcodeProblem36();

        char[][] board = new char[][]{
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(l.isValidSudoku(board));
    }
}
