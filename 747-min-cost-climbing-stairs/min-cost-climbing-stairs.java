class Solution {
    // int[] cache;

    public int minCostClimbingStairs(int[] cost) {
        // cache = new int[cost.length + 1 ] ;
        // Arrays.fill(cache , -1) ;
        // return Math.min(helper(0 , cost) , helper(1 , cost)) ;

        int n = cost.length;
        // int[] dp = new int[n + 1];
        // dp[0] = cost[0];
        // dp[1] = cost[1];
        // int prev = cost[1] ;
        // int steps2Back = cost[0] ;
        // for (int i = 2; i <= n; i++) {
        //     int curr = (i == n ? 0 : cost[i]) + Math.min( prev , steps2Back );
        //     steps2Back = prev ;
        //     prev = curr ;
        // }
        // return prev;

        int prev = 0 ;
        int step2back = Integer.MAX_VALUE ;
        for(int i = n - 1 ; i >= 0 ; i--){
            int curr = cost[i] + Math.min(prev , step2back) ;
            step2back = prev ;
            prev = curr ;
        }
        return Math.min(prev , step2back ) ;
    }


    // public int helper(int i , int[] cost){
    //     if(i == cost.length) return 0 ;
    //     if(cache[i] != -1) return cache[i] ;
    //     int nextCost = Integer.MAX_VALUE ;
    //     if( i + 2 <= cost.length){
    //         nextCost = Math.min(nextCost , helper( i + 2 , cost)) ;
    //     }
    //     nextCost = Math.min(nextCost , helper( i + 1 , cost)) ;
    //     return cache[i]  = cost[i] + nextCost ;
    // }
}