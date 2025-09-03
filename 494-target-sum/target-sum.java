class Solution {
    int[] nums ;
    int sum ;
    int[][] cache ;
    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums ;
        int sum = Arrays.stream(nums).sum();
        this.sum = sum ;
        
        int[][] cache = new int[nums.length + 1][sum*2 + 2] ;
        for(int[] arr : cache){
            Arrays.fill(arr , -1) ;
        }
        this.cache = cache ;
        return helper(0 , target) ;
    }

    public int helper(int start , int target){
        if(start == nums.length && target == 0) return 1 ;
        if(start == nums.length) return 0 ;
        if(Math.abs(target) > sum) return 0 ;

        int targetSumIndex = sum + target ;

        // System.out.println("Sum : " + sum  + " , start : " + start + "")
        if(cache[start][targetSumIndex] != -1) return cache[start][targetSumIndex] ;

        int positive = helper(start + 1 , target - nums[start]) ;
        int negative = helper(start + 1 , target + nums[start]) ;

        return cache[start][targetSumIndex] = positive + negative ;
    }
}