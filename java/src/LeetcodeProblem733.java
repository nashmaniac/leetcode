public class LeetcodeProblem733 {

    public boolean isValid(int x, int y, int row, int col) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }

    public void dfs(int[][] image, int sr, int sc, int newColor, int row, int col, int currValue) {
        if (!isValid(sr, sc, row, col)) {
            return;
        }
        if (image[sr][sc] != currValue) {
            return;
        }
        if (image[sr][sc] == newColor) {
            return;
        }
        image[sr][sc] = newColor;
        dfs(image, sr - 1, sc, newColor, row, col, currValue);
        dfs(image, sr + 1, sc, newColor, row, col, currValue);
        dfs(image, sr, sc + 1, newColor, row, col, currValue);
        dfs(image, sr, sc - 1, newColor, row, col, currValue);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int row = image.length;
        if (row == 0) {
            return image;
        }
        int col = image[0].length;
        int currValue = image[sr][sc];
        dfs(image, sr, sc, newColor, row, col, currValue);
        return image;
    }
}
