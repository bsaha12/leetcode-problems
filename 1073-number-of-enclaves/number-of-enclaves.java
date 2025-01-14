class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    DFS(i, j, grid);
                }
            }
        }

        int res = 0 ;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res += grid[i][j];
            }
        }

        return res ;
    }

    public void DFS(int i , int j , int[][] grid){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return ;
        }
        if(grid[i][j] == 0){
            return ;
        }

        grid[i][j] = 0 ;
        DFS(i , j + 1 , grid) ;
        DFS(i , j - 1 , grid) ;
        DFS(i + 1 , j , grid) ;
        DFS(i - 1 , j , grid) ;
    }
}