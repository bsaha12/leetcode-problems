class Solution {
    public int minDifference(int[] nums) {
        Arrays.sort(nums) ;
        if(nums.length <= 4) return 0 ;
        //check all possibilities(total 4)
        int min = Integer.MAX_VALUE ;
        int n = nums.length ;
        min = Math.min(min ,nums[n- 1] -  nums[3] ) ;
        min = Math.min(min ,nums[n- 4] -  nums[0] ) ;
        min = Math.min(min ,nums[n- 2] -  nums[2] ) ;
        min = Math.min(min ,nums[n- 3] -  nums[1] ) ;
        return min ;
    }
}