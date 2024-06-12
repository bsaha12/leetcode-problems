class Solution {
    public void sortColors(int[] nums) {
        int i = 0 ;
        int j = 0 ;
        int k = nums.length - 1 ;
        while(i <= k && j <= k){
            if(nums[j] == 0  ){
                swap(nums , i , j) ;
                if(i == j)
                    j++;
                i++ ;
            }else if(nums[j] == 2 ){
                swap(nums , j , k) ;
                k-- ;
            }else{
                j++ ;
            }
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}