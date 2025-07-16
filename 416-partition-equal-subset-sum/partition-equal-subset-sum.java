class Solution {
    int arr[] , total ;
    Boolean cache[][] ;

    public boolean canPartition(int[] nums) {
        if(nums.length == 1) return false ;
        arr = nums ;
        total = Arrays.stream(nums).sum() ;
        if(total == 0) return true ;
        if(total % 2 != 0) return false ;

        cache = new Boolean[arr.length + 1][total + 1] ;
        return helper(0 , 0);
    }

    public boolean helper(int i , int currSum){
        if( 2*currSum == total) return true ;
        if( i == arr.length) return false ;

        if(cache[i][currSum] != null) return cache[i][currSum] ;

        boolean chosen = helper( i + 1 , currSum + arr[i] ) ;
        boolean notChosen = helper( i + 1 , currSum  ) ;

        cache[i][currSum] = chosen || notChosen ;

        return cache[i][currSum];
    }
}