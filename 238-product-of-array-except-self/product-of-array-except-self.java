class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length ;
        int[] prefix = new int[len] ;
        int[] suffix = new int[len] ;

        // fill prefix , suffix
        prefix[0] = 1 ;
        suffix[len - 1] = 1 ;
        for(int i = 1 ; i < len ; i++){
            prefix[i] = nums[i - 1] * prefix[ i - 1] ;
            suffix[len - i - 1] = nums[len - i] * suffix[len - i] ;
        }

        int[] result = new int[len] ;
        for(int i = 0 ; i < len ; i++){
            result[i] = prefix[i] * suffix[i] ;
        }

        return result ;
    }
}