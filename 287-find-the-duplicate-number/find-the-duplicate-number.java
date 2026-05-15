class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);

        int i = 0 ; 
        int n = nums.length ;

        for(int j = 1 ; j < n ; j++){
            if(nums[i] == nums[j]) return nums[i];

            i++ ;
        }

        return 0;

    }
}