class Solution {
    public int lengthOfLIS(int[] nums) {
        int result = 0 ;
        int n = nums.length ;
        // int[] cache = new int[n] ;
        // Arrays.fill(cache , -1) ;
        // for(int i = 0 ; i < n ; i++){
        //     result = Math.max(helper(nums , i , cache) , result) ;
        // }
        // return result ;

        int[] dp = new int[n] ;
        for(int i = n-1 ; i >= 0 ; i--){
            int curr = nums[i] ;
            int currMax = 0 ;
            for(int j = i + 1 ; j < n ; j++){
                if(nums[j] > curr){
                    currMax = Math.max(dp[j] , currMax);
                }
            }
            dp[i] = currMax + 1 ;
            result = Math.max(dp[i] , result ) ;
        }
        return result ;
    }

    // top down approach
    // public int helper(int[] nums , int k , int[] cache){
    //     if(k > nums.length) return 0 ;
    //     if(cache[k] == -1){
    //         int curr = nums[k] ;
    //         int result = 0 ;
    //         for(int i = k + 1 ; i < nums.length ; i++){
    //             if( nums[i] > curr){
    //                 result = Math.max(helper(nums , i , cache), result) ;
    //             }
    //         }
    //         cache[k] = 1 + result ;
    //     }
    //     return cache[k] ;
    // }
}