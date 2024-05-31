class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums.length == 2) return nums ;
        Set<Integer> set = new HashSet<>() ;
        for(int num : nums){
            if(set.contains(num) ){
                set.remove(num) ;
            }else{
                set.add(num) ;
            }
        }
        int i = 0 ;
        int[] result = new int[2] ;
        for(int num : set){
            result[i++] = num ;
        }
        return result ;

    }//
}