class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
       Arrays.sort(nums) ;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] > 0 ){
                if(!isPossible(nums , i , k)){
                    return false ;
                }
            }
        }
        return true ;
    }//
    public boolean isPossible(int[] nums , int i , int k ){
        int prev = nums[i] ;
        nums[i] = 0 ;
        i++ ;
        int count = 1 ;
        while(i < nums.length && count < k ){
            if(nums[i] != 0 && nums[i] != prev  ){
                if(nums[i] ==  prev + 1  ){
                    nums[i] = 0 ;
                    count++ ;
                    prev++ ;
                }else{
                    return false ;
                }
            }
            i++ ;
        }

        if(count == k){
            return true ;
        }

        return false ;
    }//
}