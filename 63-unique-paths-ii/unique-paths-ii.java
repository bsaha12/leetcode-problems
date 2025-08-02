class Solution {
    // int[][] cache , grid ;
    public int uniquePathsWithObstacles(int[][] grid) {
        // int[][] grid = obstacleGrid ;
        int m = grid.length ;
        int n = grid[0].length ;
        if(grid[m - 1][n - 1] == 1) return 0 ;
        // cache = new int[m +1][n + 1] ;
        // for(int[] arr : cache){
        //     Arrays.fill(arr , -1) ;
        // }
        // return helper( 0 , 0) ;

        int[] dp = new int[n] ;
        dp[n-1] = 1 ;
        for(int j = n - 2 ; j >= 0 ; j-- ){
            dp[j] = dp[j+1] > 0 && grid[m-1][j] == 0 ? 1 : 0 ;
        }
        // System.out.println(Arrays.toString(dp)) ;

        for(int i = m - 2 ; i >= 0 ; i--){
            // intialize the last column in every row
            dp[n - 1] = dp[n - 1] > 0 && grid[i][n-1] == 0 ? 1 : 0 ;

            for(int j = n - 2 ; j >=0 ; j--){
                if(grid[i][j] == 0){
                    dp[j] += dp[j+1]  ;
                }else{
                    dp[j] = 0 ;
                }
                
            }
            // System.out.println(Arrays.toString(dp)) ;
        }
        return dp[0] ;
    }

    // public int helper(int i , int j){
    //     int m = grid.length ;
    //     int n = grid[0].length ;
    //     if( i == m || j == n ) return 0 ;
    //     if(i == m - 1 && j == n -1 && grid[i][j] == 0) return 1;

    //     if(cache[i][j] != -1) return cache[i][j] ;

    //     if(grid[i][j] == 1){
    //         cache[i][j] = 0;
    //     }else{
    //         cache[i][j] = helper(i+ 1 , j) + helper(i , j + 1 ) ;
    //     }

    //     return cache[i][j] ;
    // }
}