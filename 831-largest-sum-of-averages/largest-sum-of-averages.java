class Solution {
    int[] nums ;
    double[][] cache ;
    double[] avArr ;
    public double largestSumOfAverages(int[] nums, int k) {
        this.nums = nums ;
        cache = new double[nums.length][k + 1] ;
        // for(int[] arr : cache){ }
        avArr = new double[nums.length] ;
        int elems = 0;
        double sum = 0 ;
        for(int i = nums.length - 1 ; i >= 0 ; i--){
            elems++ ;
            sum += nums[i] ;
            avArr[i] = sum / elems ;
        }
        return helper(0 , k) ;
    }

    // maximum sum acheived when starting at start and at max prtitions allowed k
    // working on subarray starting at start
    public double helper(int start , int k){ // 1 , 3
        if(start >= nums.length) return 0 ;
        if(cache[start][k] == 0){
            if(k == 1){
                //return average starting at start
                return avArr[start] ;
            }

            // actual processing logic
            double sum = 0 ;
            int elems = 0 ;
            double result = 0 ;
            for(int i = start ; i < nums.length ; i++){
                elems++ ;
                sum += nums[i] ;
                double currAv = sum / elems ;
                double nextAv = helper(i + 1 , k - 1) ;
                result = Math.max(result , nextAv + currAv) ;
            }
            cache[start][k] = result ;
        }
        return cache[start][k] ;
    }
}