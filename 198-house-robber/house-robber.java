class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0] ;
        if(nums.length == 2) return Math.max(nums[0] , nums[1]) ;
        int prev1Step = nums[1] ;
        int prev2Step = nums[0] ;
        int prev3Step = Integer.MIN_VALUE  ;
        for(int i = 2 ; i < nums.length ; i++){
            int curr = nums[i] + Math.max(prev2Step , prev3Step) ;
            prev3Step = prev2Step ;
            prev2Step = prev1Step ;
            prev1Step = curr ;
        }
        return Math.max(prev1Step , prev2Step) ;
    }
}