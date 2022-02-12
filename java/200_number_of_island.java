class NumberOfIslandProblem {

    public boolean isValid(int x, int y, int row, int col) {
        return x>=0 && x<row && y>=0 && y<col;
    }

    public void DFS(char[][] grid, int x, int y, int row, int col) {
        if (!isValid(x, y, row, col)) {
            return;
        }
        if (grid[x][y] == '0') {
            return;
        }

        grid[x][y] = '0';
        DFS(grid, x-1, y, row, col);
        DFS(grid, x+1, y, row, col);
        DFS(grid, x, y-1, row, col);
        DFS(grid, x, y+1, row, col);
    }

    public int numIslands(char[][] grid) {
        if(grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(grid[i][j] == '1'){
                    count++;
                    DFS(grid, i, j, row, col);
                }
            }
        }
        return count;
    }

}
