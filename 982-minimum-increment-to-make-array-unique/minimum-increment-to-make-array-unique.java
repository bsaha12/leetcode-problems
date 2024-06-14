class Solution {
    public int minIncrementForUnique(int[] nums) {
        int max = 0 ;
        for(int num : nums){
            max = Math.max(num , max) ;
        }

        int[] frequency = new int[nums.length + max ] ;
        for(int num : nums){
            frequency[num]++ ;
        }

        int count = 0 ;
        for(int i = 0 ; i < frequency.length ; i++){
            if(frequency[i] <= 1 ) continue ;

            int duplicates = frequency[i] - 1 ;
            frequency[i + 1] += duplicates ;
            count += duplicates ;
        }
        return count ;
    }///
}