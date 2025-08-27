class Solution {
    // int[] nums ;
    // double[][] cache ;
    // double[] avArr ;
    public double largestSumOfAverages(int[] nums, int k) {
        // this.nums = nums ;
        // cache = new double[nums.length][k + 1] ;
        // avArr = new double[nums.length] ;
        // int elems = 0;
        // double sum = 0 ;
        // for(int i = nums.length - 1 ; i >= 0 ; i--){
        //     elems++ ;
        //     sum += nums[i] ;
        //     avArr[i] = sum / elems ;
        // }
        // return helper(0 , k) ;

        int n = nums.length ;
        double[] prev = new double[n + 1] ;
        // k -> 1
        // 0 -> 

        int elems = 0 ;
        double sum = 0 ;
        for(int i = n - 1 ; i >= 0 ; i--){
            elems++ ;
            sum += nums[i] ;
            prev[i] = sum / elems ;
        }

        // System.out.println(Arrays.toString(prev)) ;

        for(int j = 2 ; j <= k ; j++ ){
            double[] curr = new double[n + 1] ;
            for(int i = n - 1 ; i >= 0 ; i--){
                double result = 0 ;
                sum = 0 ;
                elems = 0 ;
                for(int l = i ; l < n ; l++){
                    sum += nums[l] ;
                    elems++ ;
                    double currAvg = sum / elems ;
                    double nextAvg = prev[ l + 1]  ;
                    result = Math.max(result , currAvg + nextAvg) ;
                }
                curr[i] = result ;
            }
            prev = curr ;
            // System.out.println(Arrays.toString(prev)) ;
        }

        return prev[0] ;
    }

    // maximum sum acheived when starting at start and at max partitions allowed k
    // working on subarray starting at start
    // public double helper(int start , int k){ // 1 , 3
    //     if(start >= nums.length) return 0 ;
    //     if(cache[start][k] == 0){
    //         if(k == 1){
    //             //return average starting at start
    //             return avArr[start] ;
    //         }
    //         // actual processing logic
    //         double sum = 0 ;
    //         int elems = 0 ;
    //         double result = 0 ;
    //         for(int i = start ; i < nums.length ; i++){
    //             elems++ ;
    //             sum += nums[i] ;
    //             double currAv = sum / elems ;
    //             double nextAv = helper(i + 1 , k - 1) ;
    //             result = Math.max(result , nextAv + currAv) ;
    //         }
    //         cache[start][k] = result ;
    //     }
    //     return cache[start][k] ;
    // }
}