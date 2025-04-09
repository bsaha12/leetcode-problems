class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length ;
        int[] result = new int[len] ;

        // temporarily filling result array as prefix
        int temp = 1 ;
        for(int i = 0 ; i < len ; i++){
           result[i] = temp ;
           temp *= nums[i] ;
        }


        // considering temp as suffix
        temp = 1 ;
        for(int i = len - 1 ; i >= 0 ; i--){
            result[i] *= temp ;
            temp *= nums[i] ;
        }

        return result ;
    }
}