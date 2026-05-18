class Solution {
    public int change(int amount, int[] coins) {
        // int[][] cache = new int[amount + 1][coins.length + 1] ;
        // for(int[] arr: cache){
        //     Arrays.fill(arr, -1) ;
        // }
        // return helper(amount, 0, coins, cache) ;

        int n = coins.length ;
        int[] prev = new int[amount + 1] ;
        prev[0] = 1;
        for(int i = n - 1; i >= 0; i-- ){
            int[] curr = new int[amount + 1];
            curr[0] = 1 ;
            for(int j = 1 ; j <= amount ; j++){
                int chosen = 0;
                if(j - coins[i] >= 0){
                    chosen = curr[j - coins[i]] ;
                }
                int skip = prev[j] ;

                curr[j] = chosen + skip ;
            }
            prev = curr ;
        }

        return prev[amount] ;

    }
    // public int helper(int amount, int i, int[] coins, int[][] cache){
    //     if(amount < 0) return 0;
    //     if(amount == 0) return 1;

    //     if(i >= coins.length) return 0 ;

    //     if(cache[amount][i] != -1) return cache[amount][i] ;

    //     int chosen = helper(amount - coins[i], i, coins, cache);
    //     int skip = helper(amount, i + 1, coins, cache);

    //     return  cache[amount][i] = chosen + skip ;
    // }



}