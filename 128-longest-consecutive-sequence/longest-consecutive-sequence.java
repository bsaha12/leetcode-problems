class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length <= 1){
            return nums.length ;
        }
        Arrays.sort(nums) ;
        int maxLen = 1 ;
        int currLen = 1 ;
        for(int i = 1 ; i < nums.length ; i++ ){
            if(nums[i] - nums[i-1] == 1){
                currLen++ ;
            }else if(nums[i] != nums[i-1]){
                currLen = 1 ;
            }
            if(currLen > maxLen){
                maxLen = currLen ;
            }
        }
        return maxLen ;
    }
}