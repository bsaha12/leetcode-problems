class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums) ;
        int count = 0;
        int nextAvailable = 0 ;
        for(int num : nums){
            if(num < nextAvailable){
                count +=  nextAvailable - num ;
            }else{
                nextAvailable = num ;
            }
            nextAvailable++ ;
        }
        return count ;
    }
}