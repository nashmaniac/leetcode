

public class LeetcodeProblem79 {

    public boolean found(char[][] board, String word, int index, boolean[][] visited, int i, int j, int row, int col) {
        if(index>=word.length()) {
            return true;
        }

        

        return false;
    }

    public boolean exist(char[][] board, String word) {
        int row = board.length;
        if (row == 0) {
            return false;
        }
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(board[i][j] == word.charAt(0)) {
                    boolean f = found(board, word, 1, visited, i, j, row, col);
                    if(f) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
