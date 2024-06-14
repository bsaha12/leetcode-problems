class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums) ;
        int count = 0;
        Set<Integer> set = new HashSet<>();
        int nextAvailable = 0 ;
        for(int num : nums){
            if(num < nextAvailable){
                count += Math.abs(nextAvailable - num) ;
            }else{
                nextAvailable = num ;
            }
            nextAvailable++ ;
        }
        return count ;
    }
}