class Solution {
    int[] cache ;
    public int minCostClimbingStairs(int[] cost) {
        cache = new int[cost.length + 1 ] ;
        Arrays.fill(cache , -1) ;
        return Math.min(helper(0 , cost) , helper(1 , cost)) ;
    }

    public int helper(int i , int[] cost){
        if(i == cost.length) return 0 ;

        if(cache[i] != -1) return cache[i] ;

        int nextCost = Integer.MAX_VALUE ;
        if( i + 2 <= cost.length){
            nextCost = Math.min(nextCost , helper( i + 2 , cost)) ;
        }

        nextCost = Math.min(nextCost , helper( i + 1 , cost)) ;

        return cache[i]  = cost[i] + nextCost ;
    }
}