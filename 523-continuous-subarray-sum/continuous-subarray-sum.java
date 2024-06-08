class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length <= 1) return false ;
        Map< Integer , Integer >  map = new HashMap<>() ;
        int sum = nums[0] ;
        map.put(sum % k , 0) ;
        for(int i = 1 ; i < nums.length ; i++){
            sum += nums[i] ;
            int rem = sum % k ;
            if(rem == 0) return true ;
            Integer pos = map.get(rem) ;
            if(pos != null){
                if(i - pos > 1){
                    return true ;
                }
            }else{
                map.put(rem , i) ;
            }
        }
        return false ;
    }
}