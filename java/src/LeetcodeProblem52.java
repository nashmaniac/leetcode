import java.util.ArrayList;
import java.util.List;

public class LeetcodeProblem52 {
    public boolean validate(int row, int col, int n, char[][] board) {

        int duprow = row;
        int dupcol = col;

        while(col >=0) {
            if(board[row][col] == 'Q') return false;
            col--;
        }

        row = duprow;
        col = dupcol;

        while(row >=0&& col>=0) {
            if(board[row][col] == 'Q') return false;
            col--;
            row--;
        }


        row = duprow;
        col = dupcol;

        while(row <n&& col>=0) {
            if(board[row][col] == 'Q') return false;
            col--;
            row++;
        }

        
        return true;
    }

    public void solve(int col, int n, char[][] board, List<List<String>> result) {
        if (col == n) {
            List<String> s = new ArrayList<>();
            for(int i=0;i<n;i++) {
                s.add(new String(board[i]));
            }
            result.add(s);
            return;
        }

        for (int row = 0; row< n; row++) {
            if (validate(row, col, n, board)) {
                board[row][col] = 'Q';
                solve(col+1, n, board, result);
                board[row][col] = '.';
            }
            
        }
    }

    public void print(char[][] board) {
        for(int i=0;i<board.length;i++) {
            for(char c: board[i]) {
                System.out.printf("%c ", c);
            }
            System.out.println();
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> result = new ArrayList<>();
        solve(0, n, board, result);
        return result;
    }

    public int totalNQueens(int n) {
        return solveNQueens(n).size();    
    }
}
