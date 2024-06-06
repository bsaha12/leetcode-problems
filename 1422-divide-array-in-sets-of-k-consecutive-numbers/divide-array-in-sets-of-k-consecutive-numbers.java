class Solution {
    public boolean isPossibleDivide(int[] nums, int size) {
       if(nums.length % size != 0) return false ;
        Arrays.sort(nums) ;
        Map<Integer,Integer> map = new HashMap<>() ;
        for(int num : nums){
            map.put(num , map.getOrDefault(num , 0) + 1 ) ;
        }
        for(int num : nums ){
            if(map.get(num) > 0 ){
                int k = 0 ;
                while(k < size){
                    if(map.get(num + k) != null && map.get(num + k) > 0 ){
                        map.put(num + k , map.get(num + k) - 1 ) ;
                    }else{
                        return false ;
                    }
                    k++ ;
                }
            }
        }
        return true ;
    }//
}