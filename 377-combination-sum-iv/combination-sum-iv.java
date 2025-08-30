class Solution {
    public int combinationSum4(int[] nums, int target) {
        // int n = nums.length ;
        int[] dp = new int[target + 1] ;
        dp[0] = 1 ;
        for(int i = 1 ; i <= target ; i++ ){
            int result = 0 ;
            for(int num : nums){
                if( i >= num){
                    result += dp[i - num] ;
                }
            }
            dp[i] = result ;
        }

        return dp[target] ;
    }

    // public int helper(int[] nums , int target){
    //     if(target == 0) return 1 ;

    //    int result = 0 ;
    //    for(int num : nums){
    //         if(target >= num){
    //             result += helper(nums , target - num) ;
    //         }
    //    }
    //    return result ;
    // }
}