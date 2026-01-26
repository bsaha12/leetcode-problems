class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>() ;
        for(int i = 0 ; i < nums.length ; i++){
            int curr = nums[i] ;
            int left = target - curr ;
            if(map.containsKey(left)){
                return new int[]{i , map.get(left)} ;
            }
            map.put(nums[i] , i) ;
        }
        return null ;
    }
}