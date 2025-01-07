class Solution {
    public int longestConsecutive(int[] nums) {
        int maxLen = 0 ;
        Set<Integer> set = new HashSet<>() ;
        for(int num : nums){
            set.add(num) ;
        }
        for(int num : nums){
            int currSequence = 1 ;
            int prev = num - 1 ;
            int next = num + 1 ;
            while(set.remove(prev)){
                currSequence++ ;
                prev-- ;
            }
            while(set.remove(next)){
                currSequence++ ;
                next++ ;
            }
            if(currSequence > maxLen){
                maxLen = currSequence;
            }
        }
        return maxLen ;
    }
}