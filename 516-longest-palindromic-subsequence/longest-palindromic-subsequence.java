class Solution {
    // char[] s;
    // int[][] cache;

    public int longestPalindromeSubseq(String str) {
        char[] s = str.toCharArray();
        int n = s.length;
        int[][] cache = new int[n][n];
        // for (int[] arr : cache) {
        //     Arrays.fill(arr, -1);
        // }
        // return helper(0, n - 1);

        for(int i = n - 1 ; i >= 0 ; i--){
            for(int j = i ; j < n ; j++){
                if(i == j){
                    cache[i][j] = 1 ;
                    continue ;
                }
                if(s[i] == s[j]){
                    cache[i][j] = 2 + cache[i + 1][j - 1] ;
                }else{
                    cache[i][j] = Math.max(cache[i][j-1] , cache[i+1][j]) ;
                }
            }
        }

        return cache[0][n - 1] ;
    }

    // public int helper(int i, int j) {
    //     if (i == j)
    //         return 1;
    //     if (i > j)
    //         return 0;

    //     // cache
    //     int result = cache[i][j];
    //     if (result == -1) {
    //         if (s[i] == s[j])
    //             result = 2 + helper(i + 1, j - 1);
    //         else
    //             result = Math.max(helper(i + 1, j), helper(i, j - 1));
    //     }

    //     return cache[i][j] = result;

    // }
}