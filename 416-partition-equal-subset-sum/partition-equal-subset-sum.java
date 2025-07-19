class Solution {
    Boolean[][] dp ;
    int[] arr ;

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum() ;
        if(sum % 2 != 0) return false ;
        arr = nums ;
        dp = new Boolean[nums.length + 1][sum + 1] ;
        return helper(0 , sum / 2) ;

        // int n = nums.length ;
        // boolean[][] dp = new boolean[n + 1][sum + 1] ;

        // // initialize 
        // // i = n --> false , sum = 0 -> true;
        // for(int i = 0 ; i <= n ; i++){
        //     dp[i][0] = true ;
        // }

        // // source -> ( n , 0) ;
        // // target -> (0 , sum) ;

        // for(int i = n - 1 ; i >= 0 ; i--){
        //     for(int j = 1 ; j <= sum ; j++){
        //         // if(nums[i] > j) {
        //         //     dp[i][j] = dp[i+1][j] ;
        //         // }else{
        //             dp[i][j] = dp[i+1][sum - nums[i]] || dp[i+1][j] ;
        //         // }
        //     }
        // }

        // return dp[0][sum] ;
        
    }

    public boolean helper(int i , int sum ){
        if(sum == 0) return true ;
        if(i == arr.length) return false ;

        if(dp[i][sum] != null) return dp[i][sum] ;

        if(arr[i] > sum) dp[i][sum] =  helper( i + 1 , sum) ;
        else dp[i][sum] = helper( i + 1 , sum) || helper( i + 1 , sum - arr[i]) ;

        // System.out.println(" i :  " + i + ", sum : " + sum + ", result : " + dp[i][sum]) ;
        
        return dp[i][sum] ;
    }
}