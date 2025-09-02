class Solution {
    int[] coins ;
    int[][] cache ;
    public int change(int amount, int[] coins) {
        // Arrays.sort(coins) ;
        this.coins = coins ;

        // int[] dp = new int[amount + 1] ;
        // dp[0] = 1 ;
        
        // for(int i = 1 ; i <= amount ; i++){
        //     int result = 0 ;
        //     for(int coin : coins){
        //         if(i - coin >= 0){
        //             result += dp[i - coin] ;
        //         }
        //     }
        //     dp[i] = result ;
        // }

        // System.out.println(Arrays.toString(dp)) ;
        // return dp[amount] ;

        cache = new int[coins.length + 1][amount + 1];
        for(int[] arr: cache){
            Arrays.fill(arr , -1) ;
        }
        return helper(0 , amount) ;
    }

    public int helper(int start , int amount){
    //     if(amount == 0) return 1 ;

    //     int result = 0 ;
    //     for(int coin : coins){
    //         if(amount - coin >= 0){
    //             result += helper(amount - coin) ;
    //         }
    //     }

    //     return result ;

        if(amount == 0) return 1 ;
        if(start >= coins.length) return 0 ;

        if(cache[start][amount] != -1) return cache[start][amount] ;

        int curr = coins[start] ;

        int result = helper( start + 1 , amount) ;

        if(amount - curr >= 0){
            result += helper(start , amount - curr) ;
        }

        return cache[start][amount] = result ;
    }
}