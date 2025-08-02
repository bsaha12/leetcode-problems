class Solution {
    // int[][] cache ;
    public int uniquePaths(int m, int n) {
        // int[][] dp = new int[m][n];
        // for(int[] arr : cache){
        //     Arrays.fill(arr , -1) ;
        // }
        // return helper(0 ,0 , m , n) ;

        // for(int i = 0 ; i < m ; i++){
        //     dp[i][n - 1] = 1;
        // }
        //  for(int j = 0 ; j < n ; j++){
        //     dp[m-1][j] = 1;
        // }

        // dp -> ( m - 2 , n - 2) -> (0 , 0 )
        int[] prevRow = new int[n] ;
        Arrays.fill(prevRow , 1) ;
        for (int i = m - 2; i >= 0; i--) {
            int[] currRow = new int[n] ;
            currRow[n - 1] = 1 ;
            for (int j = n - 2; j >= 0; j--) {
                // dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                currRow[j] = prevRow[j] + currRow[j+1] ;
            }
            prevRow = currRow ;
        }
        return prevRow[0] ;
        // for(int i = 0 ; i < m ; i++){
        //     for(int j = 0 ; j <n ; j++){
        //         System.out.print(dp[i][j] + " ") ;
        //     }
        //     System.out.println() ;
        // }
        // return dp[0][0];
    }

    // public int helper(int i ,int j , int m , int n){
    //     if( i == m - 1 || j == n -1  ) return 1 ;
    //     if( i == m || j == n) return 0 ;

    //     if(cache[i][j] != -1) return cache[i][j] ;

    //     return cache[i][j] = helper(i + 1 , j , m , n) + helper( i , j + 1 , m , n) ;
    // }
}