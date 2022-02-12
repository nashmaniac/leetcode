class MaxAreaOfIsland {
    public boolean isValid(int x, int y, int row, int col) {
        return x>=0 && x<row && y>=0 && y<col;
    }

    public int DFS(int[][] grid, int x, int y, int row, int col) {
        if (!isValid(x, y, row, col)) {
            return 0;
        }
        if (grid[x][y] == 0) {
            return 0;
        }

        grid[x][y] = 0;
        int bottom = DFS(grid, x-1, y, row, col);
        int up = DFS(grid, x+1, y, row, col);
        int left = DFS(grid, x, y-1, row, col);
        int right = DFS(grid, x, y+1, row, col);

        return 1+up+bottom+left+right;
    }

    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        int maxArea = 0;
        for (int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(grid[i][j] == 1){
                    int area = DFS(grid, i, j, row, col);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
}
