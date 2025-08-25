class Solution {
    // int k;
    // int[] arr, cache;

    public int maxSumAfterPartitioning(int[] arr, int k) {
        // this.arr = arr;
        // this.k = k;
        // cache = new int[arr.length];
        // Arrays.fill(cache, -1);
        // return helper(0);

        int[] dp = new int[arr.length + 1] ;

        for(int i = arr.length - 1 ; i >= 0 ; i--){
            int max = 0 ;
            int sum = 0 ;
            int elems = 0 ;
            for(int j = i ; j < arr.length && j < i + k ; j++){
                max = Math.max(max , arr[j]) ;
                elems++ ;
                int currSum = elems*max ;
                int nextSum = dp[j + 1] ;
                sum = Math.max(sum , currSum + nextSum) ;
            }
            dp[i] = sum ;
        }

        return dp[0] ;
    }

    // represent max sum generated when start at i
    // public int helper(int start) { // 0
    //     if (start >= arr.length)
    //         return 0;

    //     if (cache[start] == -1) {
    //         int maxSum = 0;
    //         int maxVal = 0;
    //         int elems = 0;
    //         for (int i = start; i < arr.length && i < start + k; i++) { // 0 , 1 , 2
    //             maxVal = Math.max(maxVal, arr[i]);
    //             elems++;
    //             int currSum = elems * maxVal;
    //             int nextSum = helper(i + 1);

    //             maxSum = Math.max(maxSum, currSum + nextSum);
    //         }
    //         cache[start] = maxSum;
    //     }

    //     return cache[start];
    // }
}