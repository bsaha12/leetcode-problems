class Solution {
    Set<Integer> set ;
    public int longestConsecutive(int[] nums) {
        set = new HashSet<>() ;
        for(int num : nums){
            set.add(num) ;
        }
        int longestLen = 0 ;
        for(int num : nums){
            int currLen = findDistance(num) ;
            longestLen = Math.max(longestLen , currLen) ;
        }

        return longestLen ;
    }///

    public int findDistance(int num){
        if(!set.contains(num)){
            return 0 ;
        }

        set.remove(num) ;

        int curr = 1 ;
        curr += findDistance(num-1) ;
        curr += findDistance(num+1) ;

        return curr ;
    }
}