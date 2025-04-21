class Solution {
    char[] str1 , str2 ;
    int[][] dp ;
    public int longestCommonSubsequence(String text1, String text2) {
        str1 = text1.toCharArray() ;
        str2 = text2.toCharArray() ;

        dp = new int[str1.length][str2.length] ;
        for(int[] arr : dp){
            Arrays.fill(arr , -1 ) ;
        }

        return helper(0 , 0) ;
    }

    public int helper(int i , int j){
        if(i >= str1.length || j >= str2.length) return 0 ;
        if(dp[i][j] != -1) return dp[i][j] ;

        char ch1 = str1[i] ;
        char ch2 = str2[j] ;
        int result = 0 ;
        if(ch1 == ch2){
            result = 1 + helper(i + 1 , j + 1) ;
        }else{
            result = Math.max( helper(i + 1 , j) , helper(i , j + 1) ) ;
        }

        dp[i][j] = result ;
        return result ;
    }
}