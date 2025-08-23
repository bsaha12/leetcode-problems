class Solution {
    public int lengthOfLIS(int[] nums) {
        int result = 1 ;
        int n = nums.length ;
        int[] cache = new int[n] ;
        Arrays.fill(cache , -1) ;
        for(int i = 0 ; i < n ; i++){
            result = Math.max(helper(nums , i , cache) , result) ;
        }
        return result ;
    }

    public int helper(int[] nums , int k , int[] cache){
        if(k > nums.length) return 0 ;
        if(cache[k] == -1){
            int curr = nums[k] ;
            int result = 0 ;
            for(int i = k + 1 ; i < nums.length ; i++){
                if( nums[i] > curr){
                    result = Math.max(helper(nums , i , cache), result) ;
                }
            }
            cache[k] = 1 + result ;
        }
        return cache[k] ;
    }
}