class Solution {
    int[][] cache , grid ;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        grid = obstacleGrid ;
        int m = grid.length ;
        int n = grid[0].length ;
        cache = new int[m +1][n + 1] ;
        for(int[] arr : cache){
            Arrays.fill(arr , -1) ;
        }

        return helper( 0 , 0) ;
    }

    public int helper(int i , int j){
        int m = grid.length ;
        int n = grid[0].length ;
        if( i == m || j == n ) return 0 ;
        if(i == m - 1 && j == n -1 && grid[i][j] == 0) return 1;

        if(cache[i][j] != -1) return cache[i][j] ;

        if(grid[i][j] == 1){
            cache[i][j] = 0;
        }else{
            cache[i][j] = helper(i+ 1 , j) + helper(i , j + 1 ) ;
        }

        return cache[i][j] ;
    }
}