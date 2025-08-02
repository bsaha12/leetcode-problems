class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] dp = new int[n];
        int result = 0 ;

        // intitialize, last row (m - 1)
        for(int j = 0 ; j < n ; j++){
            dp[j] = convert(matrix[ m - 1][j]) ;
            result = Math.max(result , dp[j] ) ;
        }

        for(int i = m - 2 ; i >= 0 ; i--){
            // last column intialize n - 1
            int[] curr = new int[n] ;
            curr[n - 1] = convert(matrix[i][n - 1]) == 1 ? 1 : 0 ;
            result = Math.max( result , curr[n - 1] );
            for( int j =  n - 2 ; j >= 0 ; j--){
                if(convert(matrix[i][j] )== 1){
                    curr[j] = 1 + Math.min( Math.min(curr[j+1] , dp[j]) , dp[j+1]) ;
                }
                result = Math.max(result , curr[j]) ;
            }
            dp = curr ;
        }

        return result*result ;
    }

    public int convert(char ch){
        return ch - '0' ;
    }
}