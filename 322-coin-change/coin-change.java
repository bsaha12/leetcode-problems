class Solution {
    int[] arr ;
    Integer[][] cache ;
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0 ;
        arr = coins;
        cache = new Integer[coins.length + 1 ][amount + 1] ;
        return helper( 0 , amount) ;
    }

    public int helper(int i , int amount){
        if(amount == 0) return 0 ;
        if(amount < 0 || i >= arr.length) return -1 ;

        if( cache[i][amount] != null ) return cache[i][amount] ;

        int chosen = helper( i , amount - arr[i] ) ;
        int nonChosen = helper(i + 1 , amount) ;

        int ans = - 1 ;

        if(chosen == -1 && nonChosen == -1) ans =  -1 ;
        else if(chosen != -1 && nonChosen != -1) ans = Math.min(1 + chosen , nonChosen);
        else if(chosen == -1) ans = nonChosen ;
        else ans = 1 + chosen ;

        return cache[i][amount] = ans  ;
    }
}