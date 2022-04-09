import java.util.ArrayList;
import java.util.List;

public class LeetcodeProblem73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return;
        } 

        int n = matrix[0].length;
        List<Integer> rows = new ArrayList<>();
        List<Integer> columns = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }

        for(int a: rows) {
            for(int j=0;j<n;j++) {
                matrix[a][j] = 0;
            }
        }

        for(int a: columns) {
            for(int j=0;j<m;j++) {
                matrix[j][a] = 0;
            }
        }

        

    }
}
