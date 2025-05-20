class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums , 0 , 0 , target ) ;
    }
    public int helper(int[] nums , int i , int prevSum , int S){
        // base condition
        if(i == nums.length) return prevSum == S ? 1 : 0 ;

        int curr = nums[i] ;
        int positive = helper(nums , i + 1 , prevSum + curr , S) ;
        int negative = helper(nums , i + 1 , prevSum - curr , S) ;

        return positive + negative ;
    }
}