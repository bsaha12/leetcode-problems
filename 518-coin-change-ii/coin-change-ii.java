class Solution {
    public int change(int amount, int[] coins) {
        int[] prev = new int[amount + 1] ;
        prev[0] = 1 ;
        for(int start = coins.length - 1 ; start >= 0 ; start--){
            int currVal = coins[start] ;
            int[] curr = new int[amount + 1] ;
            curr[0] = 1 ;
            for(int i = 1 ; i <= amount ; i++){
                int result = prev[i] ;
                if(i - currVal >= 0){
                    result += curr[i - currVal];
                }
                curr[i] = result ;
            }
            prev = curr ;
        }
        return prev[amount] ;
    }

    // public int helper(int start , int amount){

    //     if(amount == 0) return 1 ;
    //     if(start >= coins.length) return 0 ;

    //     if(cache[start][amount] != -1) return cache[start][amount] ;

    //     int curr = coins[start] ;

    //     int result = helper( start + 1 , amount) ;

    //     if(amount - curr >= 0){
    //         result += helper(start , amount - curr) ;
    //     }

    //     return cache[start][amount] = result ;
    // }
}