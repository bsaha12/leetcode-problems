class Solution {
    int[][] matrix, cache ;
    public int minPathSum(int[][] grid) {
        int m = grid.length ;
        int n = grid[0].length ;

        matrix = grid;
        cache = new int[m][n];

        for(int[] arr : cache){
            Arrays.fill(arr , -1);
        }

        return helper(0 , 0) ;

        // int[] dp = new int[n] ;
        // // initialize bottom array
        // dp[n-1] = grid[m-1][n-1] ;
        // for(int j = n - 2 ; j >= 0 ; j--){
        //     dp[j] = grid[m-1][j] + dp[j+1] ;
        // }


        // for(int i = m - 2 ; i >= 0 ; i--){
        //     dp[n-1] += grid[i][n-1];
        //     for(int j = n - 2 ; j >= 0 ; --j){
        //         dp[j] = grid[i][j] + Math.min(dp[j+1] , dp[j]) ;
        //     }
        // }
        // return  dp[0] ;


    }

    public int helper(int i, int j){
        int m = matrix.length ; 
        int n = matrix[0].length ;
        // if( i >= m || j >= n) return 0;

        if(cache[i][j] == -1){
            int nextRow = i + 1 ; 
            int nextCol = j + 1 ;

            int val = Integer.MAX_VALUE ;

            if(nextRow < m || nextCol < n){
                if(nextRow < m) val = Math.min(val, helper(nextRow, j)) ;
                if(nextCol < n) val = Math.min(val, helper(i, nextCol)) ;
            }else{
                val = 0 ;
            }

            cache[i][j] = val + matrix[i][j];
        }

        return cache[i][j] ;
    }
}