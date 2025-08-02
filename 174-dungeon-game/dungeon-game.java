class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length ;
        int n = dungeon[0].length ;

        int[] dp = new int[n] ;
        // intialize dp array i.e. bottom row m - 1
        dp[n-1] = dungeon[m -1][n-1] ;
        for(int j = n - 2 ; j >= 0 ; j--){
            dp[j] = choose(dungeon[m -1][j] , dp[j+1]) ;
        }
        // System.out.println(Arrays.toString(dp)) ;

        for(int i = m - 2 ; i >= 0 ; i--){
            // extreme right column intialize i.e. n -1
            dp[n-1] = choose(dungeon[i][n-1] , dp[n-1] ) ;
            for(int j = n - 2 ; j >= 0 ; j--){
                dp[j] = choose(dungeon[i][j] , Math.max(dp[j] , dp[j+1])) ;
            }
            // System.out.println(Arrays.toString(dp)) ;
        }

        int result =  -1*dp[0] + 1 ;

        return result > 1 ? result : 1 ;
    }

    public int choose(int curr , int iC){
        if(curr <= 0 && iC <= 0){ // - 5 , - 7
            return curr + iC ;
        }else if(curr <= 0 && iC >= 0){ // -5 , 7
            return curr ;
        }else if(curr >= 0 && iC >= 0){ // 5 , 7
            return curr ;
        }else{ // 5 , - 7 : 7 , - 5
            return curr + iC ;
        }
    }
}