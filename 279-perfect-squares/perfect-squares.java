class Solution {
    public int numSquares(int n) {
        // if(isPerfectSquare(n)) return 1 ;

        // int i = 1 ;
        // int min = n ;
        // int midPoint = n % 2 == 0 ? n / 2 : (n / 2) + 1 ;
        // while(i <= midPoint ){
        //     int first = numSquares(i) ;
        //     int second = numSquares(n - i);
        //     min = Math.min(min , first + second) ;
        //     i++ ;
        // }
        // return min ;

        int dp[] = new int[n + 1] ;
        dp[1] = 1 ; 
        for(int i = 2 ; i <= n ; i++){
            // if(isPerfectSquare(i)){
            //     dp[i] = 1 ;
            //     continue ;
            // }
            // int cnt = 1 ;
            // int min = i ;
            // int mid = i % 2 == 0 ? i / 2 : (i / 2) + 1 ;
            // while(cnt <= mid){
            //     int first = dp[cnt] ;
            //     int second = dp[i - cnt] ;
            //     min = Math.min(min , first + second) ;
            //     cnt++ ;
            // }
            // dp[i] = min ;

            dp[i] = i ;
            int j = 1;
            while(j * j <= i ){
                dp[i] = Math.min(dp[i] , 1 + dp[i - j*j]) ;
                j++ ;
            }
        }
        return dp[n] ;
    }

    // public boolean isPerfectSquare(int n){
    //     return ((int)Math.sqrt(n) * (int)Math.sqrt(n)) == n ;
    // }
}