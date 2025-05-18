class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer , Integer> map = new HashMap<>() ;
        for(int i = 0 ; i < nums.length ; i++){
            int curr = nums[i] ;
            int remainder = target - curr ;
            if(map.containsKey(remainder)){
                return new int[]{map.get(remainder) , i} ;
            }
            map.put(curr , i) ;
        }
        return null ;
    }
}