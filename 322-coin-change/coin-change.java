class Solution {
    // int[] coins ;
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0 ;
        // this.coins = coins ;
        // int result =  helper(amount) ;
        // return result == 0 ? -1 : result ;
        int[] dp = new int[amount + 1] ;
        dp[0] = 0 ;
        for(int i = 1 ; i <= amount ; i++){
            int result = 0 ;
            for(int coin : coins){
                if(i == coin){
                    result = 1 ;
                    break ;
                }

                if(i - coin > 0){
                    int curr = dp[i - coin] ;
                    if(curr > 0){
                        result = result == 0 ? curr + 1 : Math.min(result , curr + 1) ;
                    }
                }
            }
            dp[i] = result ;
        }

        return dp[amount] == 0 ? -1 : dp[amount] ;
    }

    // public int helper(int amount){
    //     int result = 0 ;
    //     for(int coin : coins){
    //         if(amount == coin){
    //             result = 1 ;
    //             break ;
    //         }
    //         if(amount - coin > 0){
    //             int curr = helper(amount - coin) ;
    //             if(curr > 0){
    //                 result = result == 0 ? curr + 1 : Math.min(result , curr + 1) ;
    //             }
    //         }
    //     }
    //     return result ;
    // }
}