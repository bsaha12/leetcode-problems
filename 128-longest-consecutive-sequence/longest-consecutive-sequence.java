class Solution {
    Set<Integer> set ;
    public int longestConsecutive(int[] nums) {
        set = new HashSet<>() ;
        for(int num : nums){
            set.add(num) ;
        }

        int longestSeq = 0 ;
        for(int num : nums){
            longestSeq = Math.max(findSeqWithNumber(num) , longestSeq) ;
        }
        return longestSeq ;
    }//

    public int findSeqWithNumber(int num){
        if(!set.contains(num)){
            return 0 ;
        }

        set.remove(num) ;
        int rightCount = findSeqWithNumber(num+1) ;
        int leftCount = findSeqWithNumber(num-1) ; 

        return rightCount + leftCount + 1 ;
    }//
}