class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0 ;
        int non1Count = 0 ;
        int maxLength = 0 ;

        for(int right = 0; right < nums.length; right++){
            if(nums[right] != 1){
                non1Count++;
            }

            if(non1Count > k){
                if(nums[left] != 1){
                    non1Count--;
                }
                left++ ;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }


        return maxLength;
    }
}