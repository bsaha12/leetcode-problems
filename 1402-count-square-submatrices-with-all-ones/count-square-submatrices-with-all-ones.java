class Solution {
    // int[][] cache, matrix;

    // public int countSquares(int[][] mat) {
        // matrix = mat;
        // int m = matrix.length;
        // int n = matrix[0].length;
        // cache = new int[m][n];
        // for (int[] arr : cache)
        //     Arrays.fill(arr, -1);

        // int result = 0;
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (matrix[i][j] == 1) {
        //             result += helper(i, j);
        //         }
        //     }
        // }

        // return result;
    // }

    // public int helper(int i , int j){
    //     if(i >= matrix.length || j >= matrix[0].length){
    //         return 0 ;
    //     }

    //     if(cache[i][j] == -1){
    //         if(matrix[i][j] == 0){
    //             cache[i][j] = 0 ;
    //         }else{
    //             int right = helper(i , j + 1) ;
    //             int bottom = helper( i  + 1 , j) ;
    //             int corner = helper(i + 1 , j + 1) ;
    //             cache[i][j] = 1 + Math.min(Math.min(right , bottom) , corner );
    //         }
    //     }
    //     return cache[i][j] ;
    // }

    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] dp = new int[n];
        int result = 0 ;

        // intitialize, last row (m - 1)
        for(int j = 0 ; j < n ; j++){
            dp[j] = matrix[ m - 1][j] ;
            result += dp[j] ;
        }

        for(int i = m- 2 ; i >= 0 ; i--){
            // last column intialize n - 1
            int[] curr = new int[n] ;
            curr[n - 1] = matrix[i][n - 1] == 1 ? 1 : 0 ;
            result += curr[n - 1] ;
            for( int j =  n - 2 ; j >= 0 ; j--){
                if(matrix[i][j] == 1){
                    curr[j] = 1 + Math.min( Math.min(curr[j+1] , dp[j]) , dp[j+1]) ;
                }
                result += curr[j] ;
            }
            dp = curr ;
        }

        return result ;
    }
}