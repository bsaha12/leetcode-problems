class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length ;
        int n = grid[0].length ;

        int[] dp = new int[n] ;
        // initialize bottom array
        dp[n-1] = grid[m-1][n-1] ;
        for(int j = n - 2 ; j >= 0 ; j--){
            dp[j] = grid[m-1][j] + dp[j+1] ;
        }


        for(int i = m - 2 ; i >= 0 ; i--){
            dp[n-1] += grid[i][n-1];
            for(int j = n - 2 ; j >= 0 ; --j){
                dp[j] = grid[i][j] + Math.min(dp[j+1] , dp[j]) ;
            }
        }
        return  dp[0] ;
    }
}