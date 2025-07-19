class Solution {
    Boolean[][] dp;
    int[] arr;

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0)
            return false;
        // arr = nums ;
        // dp = new Boolean[nums.length + 1][sum + 1] ;
        // return helper(0 , sum / 2) ;

        sum = sum / 2; // target sum is half the value
        int n = nums.length;
        // boolean[][] dp = new boolean[n + 1][sum + 1];

        // initialize 
        // i = n --> false , sum = 0 -> true; (sum = 0 will override i = n)
        // for (int i = 0; i <= n; i++) {
        //     dp[i][0] = true;
        // }

        // source -> ( n , 0) ;
        // target -> (0 , sum) ;

        // for (int i = n - 1; i >= 0; i--) {
        //     boolean[] currRow = dp[i] ;
        //     boolean[] prevRow = dp[i + 1] ;
        //     for (int j = 1; j <= sum; j++) {
        //         if (nums[i] > j) {
        //             currRow[j] = prevRow[j];
        //         } else {
        //             currRow[j] = prevRow[j - nums[i]] || prevRow[j];
        //         }
        //     }
        // }

        // return dp[0][sum];

        boolean[] prev = new boolean[sum + 1] ;
        prev[0] = true ;

        for (int i = n - 1; i >= 0; i--) {
            boolean[] curr = new boolean[sum + 1] ;
            curr[0] = true ;
            for (int j = 1; j <= sum; j++) {
                if (nums[i] > j) {
                    curr[j] = prev[j];
                } else {
                    curr[j] = prev[j - nums[i]] || prev[j];
                }
            }
            prev = curr ;
        }

        return prev[sum];

    }

    public boolean helper(int i, int sum) {
        if (sum == 0)
            return true;
        if (i == arr.length)
            return false;

        if (dp[i][sum] != null)
            return dp[i][sum];

        if (arr[i] > sum)
            dp[i][sum] = helper(i + 1, sum);
        else
            dp[i][sum] = helper(i + 1, sum) || helper(i + 1, sum - arr[i]);

        return dp[i][sum];
    }
}