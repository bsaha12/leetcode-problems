class Solution {
    // int[] nums ;
    // int sum ;
    // int[][] cache ;
    public int findTargetSumWays(int[] nums, int target) {
        // this.nums = nums ;
        // int sum = Arrays.stream(nums).sum();
        // this.sum = sum ;
        
        // int[][] cache = new int[nums.length + 1][sum*2 + ] ;
        // for(int[] arr : cache){
        //     Arrays.fill(arr , -1) ;
        // }
        // this.cache = cache ;
        // return helper(0 , target) ;

        int sum = Arrays.stream(nums).sum();
        if(Math.abs(target) > sum) return 0 ;

        int[] prev = new int[2*sum + 1] ;
        prev[sum + 0] = 1 ;


        for(int i = nums.length - 1 ; i >= 0 ; i--){
            int[] curr = new int[2*sum + 1] ;
            int num = nums[i] ;
            for(int j = -sum ; j <= sum ; j++){

                int positive = sum + j - num >= 0 ? prev[sum + j - num] : 0 ;
                int negative = sum + j + num <= 2*sum ? prev[sum + j + num] : 0 ;

                curr[sum + j] = positive + negative ;
            }
            prev = curr ;

            // System.out.println(Arrays.toString(prev)) ;
        }

        return  prev[sum + target] ;

    }

    // public int helper(int start , int target){
    //     if(start == nums.length && target == 0) return 1 ;
    //     if(start == nums.length) return 0 ;
    //     if(Math.abs(target) > sum) return 0 ;

    //     int targetSumIndex = sum + target ;

    //     if(cache[start][targetSumIndex] != -1) return cache[start][targetSumIndex] ;

    //     int positive = helper(start + 1 , target - nums[start]) ;
    //     int negative = helper(start + 1 , target + nums[start]) ;

    //     return cache[start][targetSumIndex] = positive + negative ;
    // }
}